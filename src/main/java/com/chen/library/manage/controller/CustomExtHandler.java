package com.chen.library.manage.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 标记这是一个异常处理类
 */
@ControllerAdvice
public class CustomExtHandler {
    @ExceptionHandler(value = Exception.class)
    ModelAndView HandlerException(Exception e, HttpServletRequest request){
        e.printStackTrace();
        ModelAndView modelAndView=new ModelAndView();
        //错误页路径
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg",e.getMessage());
        return modelAndView;
    }
}