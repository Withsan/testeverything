package com.wyl.schedule;

import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

/**
 * @author Wyl
 * @Description spring定时任务
 * @auther Wyl
 * @create 2019-08-12 15:46
 */
@Component
@PropertySources({
        @PropertySource("classpath:prop.properties"),
        @PropertySource("classpath:application.properties")//application其实不必使用此注解
})

public class SimpleSchedule {

    @Scheduled(fixedRateString="${schedule.simpleSchedule.times}")
    public void printCurrentTime(){
        System.out.println("现在的时间是："+LocalDateTime.now().toString());
    }
}
