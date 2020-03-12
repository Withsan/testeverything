package com.wyl.controller.springbootcontroller;

import com.wyl.redis.RedisClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description
 * @auther Wyl
 * @create 2019-08-10 15:29
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
    private RedisClient redisClient;
    @PostMapping("/setValue")
    public String setValue(String key,String value){
        if(redisClient.set(key,value)){
            return "success";
        }else {
            return "fail";
        }
    }
    @PostMapping("/getValue")
    public String getValue(String key){
        return (String)redisClient.get(key);
    }
}
