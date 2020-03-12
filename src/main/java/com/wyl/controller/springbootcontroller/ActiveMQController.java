package com.wyl.controller.springbootcontroller;

import com.wyl.activeMQ.consumer.service.TopicPubService;
import com.wyl.activeMQ.producer.service.MsgProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Wyl
 * @Description
 * @create 2019-08-10 15:29
 */
@RestController
@RequestMapping("/activeMQ")
public class ActiveMQController {
    @Resource
    private MsgProducerService msgProducerService;
    @Resource
    private TopicPubService topicPubService;
    @GetMapping("/sendMsg")
    public void sendMsg(String msg){
        msgProducerService.sendMsg(msg);
    }
    @GetMapping("/sendTopicMsg")
    public void sendTopicMsg(String msg){
        topicPubService.publishMsg(msg);
    }
}
