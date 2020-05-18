package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author TMK
 * date 2020/5/16 - 14:32
 */
@Aspect /*声明该类是一个通知*/
@Component /*等同于将该类纳入springIoc容器中*/
public class ServiceLogger {

    //通知与业务类直接连接，无需在springIoc容器配置
    //前置通知
    //获取目标对象参数需要使用的对象：
    //环绕通知为：ProceedingJoinPoint，其他通知为：JoinPoint
    //配置切点,提高重用率
    // @Pointcut("execution(public void org.example.service.impl.*.*(..))")
   @Pointcut("execution(public * org.example.service.impl.*.*(..))")
    public void targetPath(){}

    @Before("targetPath()")
    public void loginServiceBefore(JoinPoint joinPoint){
        System.out.println("方法"+joinPoint.getSignature().getName()+"开始... ...");
        System.out.print("方法(参数)："+joinPoint.getSignature().getName());
        Object[] args = joinPoint.getArgs();
        System.out.print("(");
        for (Object arg : args) {
            System.out.print(arg+",");
        }
        System.out.print(")");
        System.out.println();
    }

    @AfterReturning(value = "targetPath()",returning="resultObj")
    public void loginServiceAfter(JoinPoint joinPoint,Object resultObj) {
        if (resultObj == null) {
            System.out.println("返回值：无");
        } else {
            System.out.println("返回值：" + resultObj);
        }
        System.out.println("方法" + joinPoint.getSignature().getName() + "完毕... ...");
    }
}
