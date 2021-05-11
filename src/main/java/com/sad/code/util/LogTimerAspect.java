package com.sad.code.util;

import io.qameta.allure.Allure;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogTimerAspect {

    @Around("@annotation(LogTimer)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        val stopWatch = new StopWatch(joinPoint.getSignature().getName());
        stopWatch.start();
        val retVal = joinPoint.proceed();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        Allure.addAttachment("Stopwatch", stopWatch.prettyPrint());
        return retVal;
    }
}