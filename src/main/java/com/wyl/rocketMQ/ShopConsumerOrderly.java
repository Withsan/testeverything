package com.wyl.rocketMQ;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Wyl
 * @create 2019-08-15 19:40
 */
@Configuration
public abstract class ShopConsumerOrderly {
    @Value("${apache.rocketmq.producer.producerGroup}")
    private String producerGroup;
    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;
    private DefaultMQPushConsumer consumer ;
    public void initConsumer(String topic,String tag) throws MQClientException {
        consumer = new DefaultMQPushConsumer(producerGroup);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.subscribe(topic,tag);
        consumer.setMaxReconsumeTimes(10);
        consumer.registerMessageListener((MessageListenerOrderly) (list, consumeOrderlyContext) -> ShopConsumerOrderly.this.handling(list));
        consumer.start();
    }
    public abstract ConsumeOrderlyStatus handling(List<MessageExt> list);
}
