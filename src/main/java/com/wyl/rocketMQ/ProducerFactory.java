package com.wyl.rocketMQ;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Wyl
 * @Description
 * Simple Message Example
 *  ON THIS PAGE
 * 1. ADD DEPENDENCY
 * 2.1 SEND MESSAGES SYNCHRONOUSLY
 * 2.2 SEND MESSAGES ASYNCHRONOUSLY
 * 2.3 SEND MESSAGES IN ONE-WAY MODE
 * 3. CONSUME MESSAGES
 * 4. FIND MORE
 * Use RocketMQ to send messages in three ways: reliable synchronous, reliable asynchronous, and one-way transmission.
 * Use RocketMQ to consume messages
 * 1. Add Dependency
 * maven:
 *
 *     <dependency>
 *         <groupId>org.apache.rocketmq</groupId>
 *         <artifactId>rocketmq-client</artifactId>
 *         <version>4.3.0</version>
 *     </dependency>
 * gradle:
 *
 * compile 'org.apache.rocketmq:rocketmq-client:4.3.0'
 * 2.1 Send Messages Synchronously
 * Reliable synchronous transmission is used in extensive scenes, such as important notification messages, SMS notification, SMS marketing system, etc
 * @auther Wyl
 * @create 2019-08-15 16:18
 * 也可以使用@Bean方式返回 DefaultMQProducer
 */
@Component
public class ProducerFactory {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${apache.rocketmq.producer.producerGroup}")
    private String producerGroup;
    @Value("${apache.rocketmq.namesrvAddr}")
    private String nameserAddr;
    private DefaultMQProducer producer;

    public DefaultMQProducer getProducer() {
        return producer;
    }
    @PostConstruct
    public void init(){
        producer = new DefaultMQProducer(producerGroup);
        producer.setNamesrvAddr(nameserAddr);
        producer.setVipChannelEnabled(false);
        try {
            producer.start();
            logger.info("producer连接成功。。。。");
        }catch (MQClientException e){
            e.printStackTrace();
            logger.error(e.getErrorMessage());
        }
    }
}
