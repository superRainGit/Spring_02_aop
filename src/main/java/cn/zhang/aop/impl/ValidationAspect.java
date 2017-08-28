package cn.zhang.aop.impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 可以使用@Order指定切面的优先级   值越小  优先级越高
 * @author zhang
 *
 */
@Order(1)
@Component
@Aspect
public class ValidationAspect {

	@Before("execution(* cn.zhang.aop.impl.ArithmicCalculator.*(..))")
	public void validateArgs(JoinPoint jp) {
		System.out.println("validate : " + Arrays.asList(jp.getArgs()));
	}
}
