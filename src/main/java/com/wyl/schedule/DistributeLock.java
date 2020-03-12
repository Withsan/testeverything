package com.wyl.schedule;

import com.wyl.redis.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 定时任务获取分布式锁
 *
 * @author Wyl
 * @date 2019-11-02 18:05
 */
@Component
@PropertySource("classpath:prop.properties")
public class DistributeLock {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private RedisClient redisClient;
    private static final String luaLock = "LUA_LOCK";
    private static final Long liveTime = 20L;
    @Value("${flag}")
    private String flag;

    @Scheduled(cron = "0/5 * * * * * ")
    public void getLock() {
        Boolean isMyLock = false;
        try {
            isMyLock = lock(luaLock, flag, liveTime);
            if (isMyLock) {
                logger.info("lock success : {}", flag);
                TimeUnit.SECONDS.sleep(50);
            } else {
                String preLock = (String) redisClient.get(luaLock);
                logger.info("lock is belong to: {}", preLock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (isMyLock) {
                boolean rel = luaReleaseLock(luaLock, flag);
                if (rel) {
                    logger.info("释放锁成功");
                } else {
                    logger.info("锁已经被其他对象获取");
                }
            }
        }

    }

    /**
     * 获取lua结果
     *
     * @param key
     * @param value
     * @param ttl   默认存活时间
     * @return
     */
    public Boolean lock(String key, String value, Long ttl) {
        try {
            return redisClient.setIfAbsent(key, value, ttl, TimeUnit.SECONDS);
        } catch (Exception e) {
            logger.error("set redis occured an exception", e);
            return false;
        }
    }

    /**
     * 释放锁
     *
     * @param key
     * @param value
     * @return
     */
    public Boolean luaReleaseLock(String key, String value) {
        return false;
    }

}
