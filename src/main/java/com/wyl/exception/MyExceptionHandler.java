package com.wyl.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wyl
 * @Description 全局异常配置,可返回json，也可返回页面
 * @create 2019-08-18 10:23
 */
//@RestControllerAdvice
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    Object exceptionHandle(Exception e, HttpServletRequest request){
        e.printStackTrace();
        Map<String,String> result = new HashMap<>(3);
        result.put("code","500");
        result.put("msg","服务器出异常啦");
        result.put("url",request.getRequestURI());
        return result;
    }
}
