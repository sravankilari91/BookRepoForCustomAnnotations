package com.customannotatio.BookRepo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TraceableAspect {

	@Around("@annotation(Traceable)")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("Input :\n" + joinPoint.getArgs()[0]);
		Object result = joinPoint.proceed();
		System.out.println(result);

		return result;
	}

}
