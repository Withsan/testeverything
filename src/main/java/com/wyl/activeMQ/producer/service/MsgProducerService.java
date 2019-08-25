package com.wyl.activeMQ.producer.service;

import javax.jms.Destination;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-14 16:40
 */
public interface MsgProducerService {
    /**
     * 发送消息
     *
     * @param msg
     */
    public void sendMsg(String msg);

    /**
     * 发送消息至 destination
     *
     * @param destination
     * @param msg
     */
    public void sendMsg(Destination destination, String msg);
}
