package com.spring.test;

import com.spring.aop.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPByAnnotationTest {
    /**
     * 在ioc容器中无法获取目标对象，只能获取代理对象
     */
    @Test
    public void testAOPByAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.mul(1,1);
    }

    @Test
    public void test(){
        float yuexin=4;
        float zongbao=0;
        float nianxin=60;
        float gupiao=20;
        int n = 100;
        for (int i = 30; i < 41; i++) {
            nianxin = yuexin * 16;
            zongbao += nianxin;
            System.out.println(i+"岁  年薪"+nianxin+"   股票"+gupiao+"   一共"+(zongbao+gupiao));
            yuexin *= 1.15;
            gupiao += 10;
        }
    }
}
