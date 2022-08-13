package com.spring.test;

import com.spring.controller.UserController;
import com.spring.dao.UserDao;
import com.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByAnnotationTest {

    /**
     * @Autowired:实现自动装配功能的注解
     * 1、@Autowired注解能够标识的位置
     * a>标识在成员变量上，此时不需要设置成员变量的set方法
     * b>标识在set方法上
     * c>标识在为当前成员变量赋值的有参构造上
     * 2、@Autowired注解的原理
     * a>默认通过byType的方式，在IOC容器中通过类型匹配某个bean为属性赋值
     * b>若有多个类型匹配的bean，此时会自动转换为byName的方式实现自动装配的效果
     * 即将要赋值的属性的属性名作为bean的id匹配某个bean为属性赋值
     * c>若byType和byName的方式都无法实现自动装配，即IOC容器中有多个类型匹配的bean
     * 且这些bean的id和要赋值的属性的属性名都不一致，此时抛出异常
     * d>此时可以在要赋值的属性上，添加一个注解@Qualifier
     * 通过该注解的value属性值，指定某个bean的id，将这个bean为属性赋值
     *
     * @Autowired中有属性required，默认值为true，因此在自动装配无法找到相应的bean时，会装配失败
     * 可以将属性required的值设置为true，则表示能装就装，装不上就不装，此时自动装配的属性为默认值
     * 但是实际开发时，基本上所有需要装配组件的地方都是必须装配的，用不上这个属性。
     */
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }
}
