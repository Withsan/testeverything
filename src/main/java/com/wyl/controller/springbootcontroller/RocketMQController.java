package com.wyl.controller.springbootcontroller;

import com.wyl.rocketMQ.ProducerFactory;
import com.wyl.rocketMQ.QueueSelecter.MyQueueSelector;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-15 16:47
 */
@RestController
@RequestMapping("/rocket")
public class RocketMQController {
    @Resource
    private ProducerFactory producerFactory;
    /**
     * 1 同步消息 会等到接收方返回响应之后才会发送下一条消息
     * */
    @PostMapping("/sendSyncMsg")
    public void sendSyncMsg(String topic, String tag, String msg) {
        DefaultMQProducer mqProducer = producerFactory.getProducer();
        try {
            Message message = new Message(topic,
                    tag, (msg).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            SendResult sendResult = mqProducer.send(message);
            System.out.println(sendResult.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 1.1 使用同步发送方式来确保消息投递的顺序性，并且使用queueSelector确定投递到哪一个queue
     * */
    @PostMapping("/sendMsgOrderly")
    public void sendMsgOrderly(String topic, String tag) {
        DefaultMQProducer mqProducer = producerFactory.getProducer();
        List<OrderMsg> orderMsgs = new ArrayList<>(3);
        OrderMsg orderMsg ;
        for (int i = 0; i < 3; i++) {
            orderMsg = new OrderMsg("20191003"+i,"创建订单");
            orderMsgs.add(orderMsg);
            orderMsg = new OrderMsg("20191003"+i,"支付订单");
            orderMsgs.add(orderMsg);
            orderMsg = new OrderMsg("20191003"+i,"评价订单");
            orderMsgs.add(orderMsg);
        }
        MyQueueSelector myQueueSelector = new MyQueueSelector();
        try {
            for (int i = 0; i < orderMsgs.size(); i++) {
                Message message = new Message(topic,
                        tag, (orderMsgs.get(i).toString()).getBytes(RemotingHelper.DEFAULT_CHARSET)
                );
                SendResult sendResult = mqProducer.send(message,myQueueSelector,orderMsgs.get(i).orderId);
                System.err.println(sendResult);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class OrderMsg implements Serializable {
        private static final long serialVersionUID = 1234L;
        private String orderId;
        private String orderStstus;
        public OrderMsg(String orderId,String orderStstus){
            this.orderId = orderId;
            this.orderStstus = orderStstus;
        }
        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getOrderStstus() {
            return orderStstus;
        }

        public void setOrderStstus(String orderStstus) {
            this.orderStstus = orderStstus;
        }

        @Override
        public String toString() {
            return "OrderMsg{" +
                    "orderId='" + orderId + '\'' +
                    ", orderStstus='" + orderStstus + '\'' +
                    '}';
        }
    }
    /**
     * 2 异步消息 发送消息后，不等接收方返回响应，接着发送下一条，发送方通过回调接口接收服务器响应，并对响应结果进行处理。
     * */
    @PostMapping("/sendAsyncMsg")
    public void sendAsyncMsg(String topic, String tag, String msg) {
        DefaultMQProducer mqProducer = producerFactory.getProducer();
        try {
            Message message = new Message(topic,
                    tag, (msg).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            mqProducer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.println(sendResult);
                }

                @Override
                public void onException(Throwable e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 3 中等可靠性传输，只负责发送，什么都不用管
     * */
    @PostMapping("/sendOneWay")
    public void sendOneWay(String topic, String tag, String msg) {
        DefaultMQProducer mqProducer = producerFactory.getProducer();
        try {
            Message message = new Message(topic,
                    tag, (msg).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            mqProducer.sendOneway(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
