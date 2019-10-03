package com.wyl.rocketMQ;

import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wyl
 * @create 2019-08-15 19:40
 */
@Service
@PropertySource("classpath:prop.properties")
public class ShopConsumerOrderlyImpl extends ShopConsumerOrderly implements ApplicationListener<ContextRefreshedEvent> {
    @Value("${rocketmq.shop.topic}")
    private String topic;
    @Value("${rocketmq.shop.tag}")
    private String tag;

    @Override
    public ConsumeOrderlyStatus handling(List<MessageExt> list) {
        System.out.println("Orderly");
        list.stream().forEach((messageExt -> {
            System.out.println(new String(messageExt.getBody()));
        }));
        return ConsumeOrderlyStatus.SUCCESS;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            super.initConsumer(topic, tag);
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
