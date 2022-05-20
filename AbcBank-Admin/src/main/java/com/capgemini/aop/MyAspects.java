//package com.capgemini.aop;
//
//import org.slf4j.Logger;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@Component
//@Aspect
//public class MyAspects {
//	
//	private Logger logger = LoggerFactory.getLogger(MyAspects.class);
//
//	@Pointcut(value="execution(* com.capgemini.*.*.*(..) )")
//	public void pointcut() {
//
//	}
//
//	@Around("pointcut()")
//	public Object applicationLogger(ProceedingJoinPoint joinPoint) throws Throwable
//	{
//
//	ObjectMapper map = new ObjectMapper();
//	String MethodName = joinPoint.getSignature().getName();
//	String ClassName = joinPoint.getTarget().getClass().toString();
//	Object[] array = joinPoint.getArgs();
//	logger.info("Method invoked" + ClassName+ " : " +
//	MethodName + "Args" + map.writeValueAsString(array)); Object obj =
//	joinPoint.proceed();
//
//	logger.info("Response " + ClassName + " : " +
//	MethodName + "Args" + map.writeValueAsString(obj));
//	return obj;
//}
//}
//	
//	
//
//
