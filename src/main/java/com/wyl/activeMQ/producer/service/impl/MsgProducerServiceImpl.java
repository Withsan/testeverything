package com.wyl.activeMQ.producer.service.impl;

import com.wyl.activeMQ.producer.service.MsgProducerService;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Queue;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-14 15:04
 */
@Component
public class MsgProducerServiceImpl implements MsgProducerService {
    @Resource
    private Queue queue;
    @Resource
    JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发送消息
     *
     * @param msg
     */
    @Override
    public void sendMsg(String msg) {
        jmsMessagingTemplate.convertAndSend(queue,msg);
    }

    /**
     * 发送消息至 destination
     *
     * @param destination
     * @param msg
     */
    @Override
    public void sendMsg(Destination destination, String msg) {
        jmsMessagingTemplate.convertAndSend(destination,msg);
    }
}
