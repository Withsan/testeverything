package com.wyl.rocketMQ.queueSelecter;

import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class MyQueueSelector implements MessageQueueSelector {
    @Override
    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
        String orderId = (String)arg;
        int index = Integer.valueOf(orderId)%3;
        return mqs.get(index);
    }
}
