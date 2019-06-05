package com.yaoyili.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;

@ControllerAdvice
@ResponseBody   //这里设置返回数据到响应体
public class RestExceptionHandler{

    @ExceptionHandler(Exception.class)
    public ResponseWrapper handler(HandlerMethod handlerMethod, Exception e){//这里引入handlerMethod


        Method m = handlerMethod.getMethod();

        Class<?> clazz = handlerMethod.getBeanType();
        //判断访问的url是否为rest 请求
        boolean isRestReq = (m.getAnnotation(ResponseBody.class)!=null||clazz.getAnnotation(ResponseBody.class)!=null
                ||clazz.getAnnotation(RestController.class)!=null);

        if(isRestReq){//如果为rest请求，则返回数据
            ResponseWrapper res = new ResponseWrapper(500, e.getMessage(), new Object());
            return res;
        }else{//如果不是rest请求，则抛出异常
            throw new RuntimeException("handler");
        }

    }

}