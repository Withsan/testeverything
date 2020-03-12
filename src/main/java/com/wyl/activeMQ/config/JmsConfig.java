package com.wyl.activeMQ.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author Wyl
 * @Description
 * @auther Wyl
 * @create 2019-08-14 14:36
 */
@Configuration
@PropertySource("classpath:prop.properties")
public class JmsConfig {

    @Value("${spring.active.queue.name}")
    private String queueName;
    @Value("${spring.active.topic.name}")
    private String topicName;

    @Bean
    public Queue getActiveQueue(){
        return new ActiveMQQueue(queueName);
    }
    @Bean
    public Topic getActiveTopic(){
        return new ActiveMQTopic(topicName);
    }
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        //开启发布订阅模式
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
}
