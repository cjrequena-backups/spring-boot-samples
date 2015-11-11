package com.sample.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitorAspect {

	@Pointcut("@annotation(com.sample.aop.annotation.Monitored)")
	public void monitoredMethodPointCut() {
		// Pointcut MethodsPointCut need no body
	}


	@AfterReturning("execution(* com.sample.aop..*Service.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.println("Completed: " + joinPoint);
	}

	@Around("monitoredMethodPointCut()")
	public void monitoring(JoinPoint joinPoint) {
		System.out.println("Completed: " + joinPoint);
	}

}