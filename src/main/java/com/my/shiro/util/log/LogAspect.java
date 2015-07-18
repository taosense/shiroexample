package com.my.shiro.util.log;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

@Aspect
public class LogAspect {
	
	@Around("@annotation(com.my.shiro.util.log.LogAnnotation)  && (args(userId,..))")
    public Object around(ProceedingJoinPoint joinPoint,String userId) throws Throwable {
        // 取得被拦截的方法及其注解
        MethodSignature joinPointObject = (MethodSignature) joinPoint.getSignature();
        Method method = joinPointObject.getMethod();
        LogAnnotation LogAn = method.getAnnotation(LogAnnotation.class);
        Object[] args = joinPoint.getArgs();
        System.out.println(LogAn.mothodName());
        System.out.println("method:" + method.getName()+ ",args:" +Arrays.toString(args));
        System.out.println(userId);
        System.out.println(Arrays.toString(args));
        // 继续执行获取被代理的方法结果
        Object ro = joinPoint.proceed();
        System.out.println("end");
        return ro;
    }
}
