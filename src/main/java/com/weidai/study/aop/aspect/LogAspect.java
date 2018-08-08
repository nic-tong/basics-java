package com.weidai.study.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @描述
 * @author nic 
 * @time：2018年6月14日 下午9:12:48
 */
public class LogAspect {

	private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

	public void before(JoinPoint joinPoint) {
		logger.info("execute before" + joinPoint);
	}
	
	public void after(JoinPoint joinPoint) {
		System.out.println(joinPoint.getKind());
		System.out.println(joinPoint.getTarget());
		System.out.println(joinPoint.getThis());
		System.out.println(joinPoint.getClass());
		System.out.println(joinPoint.getSignature());
		logger.info("execute after" + joinPoint);
	}
	
	public void afterReturn(JoinPoint joinPoint) {
		logger.info("execute after return " + joinPoint);
	}
	
	public void afterThrowing(JoinPoint joinPoint) {
		logger.info("execute after return " + joinPoint);
	}
	
}
