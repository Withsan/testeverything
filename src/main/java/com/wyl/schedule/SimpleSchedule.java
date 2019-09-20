package com.wyl.schedule;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
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
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:ss:mm");

    @Value("${schedule.simpleSchedule.times}")
    private  String fixedRate;
    @Value("${spring.datasource.url}")
    private  String urls;

    @Scheduled(fixedRateString="2000")
    public void printCurrentTime(){
        /*Date  currentTime = new Date();
        String currentTimeStr = sdf.format(currentTime);
        System.out.println(fixedRate);
        System.out.println(urls);*/
//        System.out.println("现在的时间是："+currentTimeStr);
    }
}
