package com.wyl.rocketMQ;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Wyl
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
    }
}
