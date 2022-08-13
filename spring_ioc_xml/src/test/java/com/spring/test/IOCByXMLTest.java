package com.spring.test;

import com.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXMLTest {
    /**
     *  获取bean的三种方式
     *  1、根据bean的id获取
     *  2、根据bean的类型获取
     *  注意：根据类型获取bean时，要求IOC容器中有且只有一个类型匹配的bean
     *  3、根据bean的类型和id获取
     *
     *  结论：
     *  根据类型来获取bean时，在满足bean唯一性的前提下
     *  其实只是看：『对象 instanceof 指定的类型』的返回结果
     *  只要返回的是true就可以认定为和类型匹配，能够获取到。
     *
     *  即通过bean的类型，bean所继承的类的类型，bean所实现的接口的类型都可以获取bean
     */
    @Test
    public void testIOC(){
        //获取ioc容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        //获取bean
        //Student studentOne = (Student) ioc.getBean("studentOne");
        Student student = ioc.getBean("studentFive",Student.class);
        System.out.println(student);
    }
}
