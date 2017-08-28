package cn.zhang.aop.impl.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
	
	public void before(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		List<Object> args = Arrays.asList(jp.getArgs());
		System.out.println("The method " + methodName +" begins " + args);
	}
	
	public void after(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		System.out.println("The method " + methodName +" ends");
	}

	public void afterReturnning(JoinPoint jp, Object result) {
		String methodName = jp.getSignature().getName();
		System.out.println("The method " + methodName +" ends " + result);
	}

	public void afterThrowing(JoinPoint jp, Exception ex) {
		String methodName = jp.getSignature().getName();
		System.out.println("The method " + methodName +" occurs exception : " + ex);
	}
	
	public Object around(ProceedingJoinPoint pjd) {
		Object result = null;
		return result;
	}
	
}
