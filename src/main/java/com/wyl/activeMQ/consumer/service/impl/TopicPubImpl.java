package com.wyl.activeMQ.consumer.service.impl;

import com.wyl.activeMQ.consumer.service.TopicPubService;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Topic;

/**
 * @author Wyl
 * @Description
 * @auther Wyl
 * @create 2019-08-14 20:17
 */
@Component
public class TopicPubImpl implements TopicPubService {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource
    private Topic topic;
    @Override
    public void publishMsg(String msg){
        jmsMessagingTemplate.convertAndSend(topic,msg);
    }

}
