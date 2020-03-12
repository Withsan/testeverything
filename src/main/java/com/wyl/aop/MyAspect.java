package com.wyl.aop;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.Map;

/**
 * @Description 切面测试类
 * @auther Wyl
 * @create 2019-08-18 20:05
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(public * com.wyl.controller..*.*(..))")
    public void getMethodArgs(){
    }
    @Before("getMethodArgs()")
    public void Before(JoinPoint joinPoint){
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        for (int i = 0; i < obj.length ; i++) {
            System.out.println("第"+i+"个参数"+obj[i]);
        }
        // AOP代理类的信息
        System.out.println("AOP代理类信息"+joinPoint.getThis());
        // 代理的目标对象
        System.out.println("代理目标对象"+joinPoint.getTarget());
        // 用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        // 代理的是哪一个方法
        System.out.println("代理方法"+signature.getName());
        // AOP代理类的名字
        System.out.println("AOP代理类名字"+signature.getDeclaringTypeName());
        // AOP代理类的类（class）信息
        signature.getDeclaringType();
        System.out.println("AOP代理类（class）信息"+signature.getDeclaringType());
        // 获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        // 从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        // 如果要获取Session信息的话，可以这样写：
        HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        // 获取请求参数
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,String> parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }
        String str = JSON.toJSONString(parameterMap);
        if(obj.length > 0) {
            System.out.println("请求的参数信息为："+str);
        }
    }
    @After("getMethodArgs()")
    public void After(){
        System.out.println("Aop后置通知");
    }
    @Around("getMethodArgs()")
    public void Around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Aop环绕通知proceed前");
        try {
            proceedingJoinPoint.proceed();
        }catch (Throwable e){
            e.printStackTrace();
        }
        System.out.println("Aop环绕通知proceed后");
    }

}
