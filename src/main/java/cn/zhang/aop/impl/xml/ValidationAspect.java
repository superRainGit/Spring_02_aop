package cn.zhang.aop.impl.xml;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class ValidationAspect {

	public void validateArgs(JoinPoint jp) {
		System.out.println("validate : " + Arrays.asList(jp.getArgs()));
	}
}
