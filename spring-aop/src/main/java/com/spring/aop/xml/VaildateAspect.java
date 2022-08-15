package com.spring.aop.xml;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切面的优先级
 * 通过@Order设置优先级，值约小优先级越高，默认为Integer的最大值
 */
@Component
@Aspect
@Order(1)
public class VaildateAspect {

    @Before("com.spring.aop.xml.LoggerAspect.pointcut()")
    public void beforeMethod(){
        System.out.println("ValidateAspect-->前置通知");
    }
}
