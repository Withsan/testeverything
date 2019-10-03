package com.wyl.rocketMQ.QueueSelecter;

import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

public class MyQueueSelector implements MessageQueueSelector {
    @Override
    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
        String orderId = (String)arg;
        int index = Integer.valueOf(orderId)%3;
        return mqs.get(index);
    }
}
