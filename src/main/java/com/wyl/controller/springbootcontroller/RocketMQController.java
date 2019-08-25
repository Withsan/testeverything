package com.wyl.controller.springbootcontroller;

import com.wyl.rocketMQ.Consumers;
import com.wyl.rocketMQ.ProducerFactory;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    @RequestMapping("/sendMsg")
    public void sendSyncMsg(String topic,String tag ,String msg){
        DefaultMQProducer mqProducer = producerFactory.getProducer();
        try {
            Message message = new Message(topic /* Topic */,
                    tag /* Tag */, (msg).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //同步消息 会等到接收方返回响应之后才会发送下一条消息
            SendResult sendResult = mqProducer.send(message);
            System.out.println(sendResult.toString());
            //异步消息 发送消息后，不等接收方返回响应，接着发送下一条，发送方通过回调接口接收服务器响应，并对响应结果进行处理。
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
            //中等可靠性传输，只负责发送，什么都不用管
            mqProducer.sendOneway(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Resource
    Consumers consumerFactory;
    @RequestMapping("/getMsg")
    public void getMsg(String topic,String tag){
        DefaultMQPushConsumer consumer =consumerFactory.getConsumer();
        try {
            consumer.subscribe(topic,tag);
            consumer.registerMessageListener((MessageListenerConcurrently)(msgs, context) ->{
                msgs.stream().forEach(System.out::println);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });
            consumer.start();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
