package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 这个启动类必须放在controller所在包的同级下，是对自己同级包进行扫描
 * 不这样的话必须使用@ComponentScan(value = {"com.wyl.controller"}) 这样的注解
 */
@SpringBootApplication
//@ComponentScan(value = {"com.wyl.controller"})

//MybaitisMapper扫描
@MapperScan("com.wyl.mybatis.mapper")

//开启spring定时任务
@EnableScheduling

//开启异步任务
@EnableAsync

//开启支持JMS
@EnableJms

//开启aop（默认已经开启）
//@EnableAspectJAutoProxy
public class TestEverythingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestEverythingApplication.class, args);
	}
}
