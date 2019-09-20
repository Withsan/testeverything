package com.wyl.activeMQ.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-14 17:35
 */
@Component
public class MyConsumer {
    /**
     * 即使定义了三个，但是每次只有一个消费者可以消费消息
     * @param msg
     */
    /**长连接监听*/
//    @JmsListener(destination="lin.queue")
    public void receivedMsg(String msg){
          System.out.println("第一个消费者"+msg);
    }
    /**长连接监听*/
//    @JmsListener(destination="lin.queue")
    public void receivedMsg2(String msg){
        System.out.println("第二个消费者"+msg);
    }
    /**长连接监听*/
//    @JmsListener(destination="lin.queue")
    public void receivedMsg3(String msg){
        System.out.println("第三个消费者"+msg);
    }
}
