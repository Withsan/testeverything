package com.wyl.rocketMQ;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-15 19:40
 */
@Component
public class Consumers {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${apache.rocketmq.producer.producerGroup}")
    private String producerGroup;
    @Value("${apache.rocketmq.namesrvAddr}")
    private String nameserAddr;

    private DefaultMQPushConsumer consumer;

    public DefaultMQPushConsumer getConsumer() {
        return consumer;
    }

    @PostConstruct
    public void init(){
        consumer = new DefaultMQPushConsumer(producerGroup);
        consumer.setNamesrvAddr(nameserAddr);
        try {
            consumer.subscribe("linsNew","hot");
            consumer.registerMessageListener((MessageListenerConcurrently)(msgs, context) ->{
                msgs.stream().forEach(System.out::println);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });
            consumer.start();
            logger.info("consumer连接成功。。。。");
        }catch (MQClientException e){
            e.printStackTrace();
            logger.error(e.getErrorMessage());
        }
    }
}
