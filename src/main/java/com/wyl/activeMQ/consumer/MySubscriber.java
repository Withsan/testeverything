package com.wyl.activeMQ.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-14 17:35
 */
@Component
public class MySubscriber {
    /**
     * 即使定义了三个，每个消息三个订阅者都会读到
     * @param msg
     */
    /**长连接监听*/
//    @JmsListener(destination="lin.topic",containerFactory="jmsListenerContainerTopic")
    public void receivedMsg(String msg){
          System.out.println("第一个订阅者"+msg);
    }
    /**长连接监听*/
//    @JmsListener(destination="lin.topic",containerFactory="jmsListenerContainerTopic")
    public void receivedMsg2(String msg){
        System.out.println("第二个订阅者"+msg);
    }
    /**长连接监听*/
//    @JmsListener(destination="lin.topic",containerFactory="jmsListenerContainerTopic")
    public void receivedMsg3(String msg){
        System.out.println("第三个订阅者"+msg);
    }
}
