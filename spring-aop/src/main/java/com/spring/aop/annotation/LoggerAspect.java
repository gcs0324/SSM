package com.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 在切面中，需要通过指定的注解将方法标识为通知方法
 * @Before：前置通知，在目标对象方法执行之前执行
 * @After：后置通知，在目标对象方法的finally字句中执行
 * @AfterReturning：返回通知，在目标方法返回之后执行
 * @AfterThrowing：异常通知，在目标对象方法的catch子句中执行
 *
 * 重用切入点表达式
 * 获取切入点信息
 *
 * 通知的执行顺序
 *  前置通知
 *  目标操作
 *  返回通知或异常通知
 *  后置通知
 */
@Component
@Aspect //将当前组件标识为切面
public class LoggerAspect {

    @Pointcut("execution(* com.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointcut(){}

    //@Before("execution(public int com.spring.aop.annotation.CalculatorImpl.add(int,int))")
    @Before("pointcut()")
    public void beforeAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        //获取连接点所对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect,方法："+signature.getName()+",参数："+ Arrays.toString(args));
    }

    @After("pointcut()")
    public void afterAdviceMethod(JoinPoint joinPoint){
        //获取连接点所对应方法的方法名
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法："+signature.getName()+",执行完毕");
    }

    /**
     * 在返回通知中若要获取目标对象的返回值
     * 只需要通过@AfterReturning注解的returning属性
     * 就可以将通知方法的某个参数指定为接受目标对象方法的返回值的参数
     */
    @AfterReturning(value = "pointcut()",returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint,Object result){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法："+signature.getName()+"，结果"+result);
    }

    /**
     * 通过@AfterThrowing中的属性throwing，用来将通知方法的某个形参，接收目标方法的异常
     */
    @AfterThrowing(value = "pointcut()",throwing = "ex")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint,Throwable ex){
        //获取连接点所对应方法的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法："+signature.getName()+"，异常："+ex);
    }


    @Around("pointcut()")
    //环绕通知方法的返回值一定要和目标对象方法的返回值一致
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            System.out.println("环绕通知-->前置通知");
            //表示目标方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-->返回通知");
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("环绕通知-->异常通知");
        } finally {
            System.out.println("环绕通知-->后置通知");
        }
        return result;
    }
}
