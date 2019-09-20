package com.wyl.activeMQ.consumer.service.impl;

import com.wyl.activeMQ.consumer.service.MsgConsumerService;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Queue;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-14 16:42
 */
@Component
public class MsgConsumerServiceImpl implements MsgConsumerService {


    /**
     * 默认消息队列
     * */
    @Resource
    private Queue queue;
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    /**
     * 默认接收消息
     */
    @Override
    public void receivedMsg() {
        Message message =jmsMessagingTemplate.receive(queue);
        System.out.println(message.getPayload().toString()+"jess's");
    }

    /**
     * 从目标地址接收消息
     *
     * @param destination
     */
    @Override
    public void receviedMsg(Destination destination) {

    }
}
