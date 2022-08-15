package com.spring.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * 切面的优先级
 * 通过@Order设置优先级，值约小优先级越高，默认为Integer的最大值
 */
@Component

public class VaildateAspect {

    public void beforeMethod(){
        System.out.println("ValidateAspect-->前置通知");
    }
}
