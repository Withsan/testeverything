package com.wyl.activeMQ.consumer.service;

import javax.jms.Destination;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-14 16:42
 */
public interface MsgConsumerService {
    /**
     * 默认接收消息
     */
    void receivedMsg();

    /**
     * 从目标地址接收消息
     * @param destination
     */
    void receviedMsg(Destination destination);
}
