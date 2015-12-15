package com.sample.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class ServiceMonitorAspect {

	@Pointcut("@annotation(com.sample.aop.annotation.Monitored)")
	public void monitoredMethodPointCut() {
		// Pointcut MethodsPointCut need no body
	}


	@AfterReturning("execution(* com.sample.aop..*Service.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		log.info("Completed: " + joinPoint);
	}

	@Around("monitoredMethodPointCut()")
	public Object monitoring(ProceedingJoinPoint  proceedingJoinPoint) throws Throwable {
		// start stopwatch
        Object retVal = proceedingJoinPoint.proceed();
        log.info("Completed: " + proceedingJoinPoint);
        // stop stopwatch
        return retVal;	
	}

}