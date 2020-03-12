package com.wyl.rocketMQ.producerfatory;

import com.wyl.rocketMQ.transactionchecklistener.MyTransactionListener;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Wyl
 * @Description
 * Simple Message Example
 *  ON THIS PAGE
 * 1. ADD DEPENDENCY
 * 2.1 SEND MESSAGES SYNCHRONOUSLY
 * 2.2 SEND MESSAGES ASYNCHRONOUSLY
 * 2.3 SEND MESSAGES IN ONE-WAY MODE
 * 3. CONSUME MESSAGES
 * 4. FIND MORE
 * Use RocketMQ to send messages in three ways: reliable synchronous, reliable asynchronous, and one-way transmission.
 * Use RocketMQ to consume messages
 * 1. Add Dependency
 * maven:
 *
 *     <dependency>
 *         <groupId>org.apache.rocketmq</groupId>
 *         <artifactId>rocketmq-client</artifactId>
 *         <version>4.3.0</version>
 *     </dependency>
 * gradle:
 *
 * compile 'org.apache.rocketmq:rocketmq-client:4.3.0'
 * 2.1 Send Messages Synchronously
 * Reliable synchronous transmission is used in extensive scenes, such as important notification messages, SMS notification, SMS marketing system, etc
 * @auther Wyl
 * @create 2019-08-15 16:18
 * 也可以使用@Bean方式返回 DefaultMQProducer
 */
@Component
public class TransactionProducerFactory {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${apache.rocketmq.producer.TransactionProducerGroup}")
    private String producerGroup;
    @Value("${apache.rocketmq.namesrvAddr}")
    private String nameserAddr;
    private TransactionMQProducer producer;
    @Resource
    private MyTransactionListener myTransactionListener;

    public TransactionMQProducer  getProducer() {
        return producer;
    }
    private ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2000), r -> {
        Thread thread = new Thread(r);
        thread.setName("client-transaction-msg-check-thread");
        return thread;
    });
    @PostConstruct
    public void init(){
        producer = new TransactionMQProducer(producerGroup);
        producer.setNamesrvAddr(nameserAddr);
        producer.setTransactionListener(myTransactionListener);
        producer.setExecutorService(executorService);
        producer.setVipChannelEnabled(false);
        try {
            producer.start();
            logger.info("TransactionProducer连接成功。。。。");
        }catch (MQClientException e){
            e.printStackTrace();
            logger.error(e.getErrorMessage());
        }
    }
}
