package cn.zhang.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zhang.aop.impl.xml.ArithmicCalculator;


public class TestSpringAopxml {

	public ApplicationContext getApplicationContext() {
		return new ClassPathXmlApplicationContext("applicationContext-xml.xml");
	}
	
	/**
	 * 测试基于XML的AOP的简单示例
	 */
	@Test
	public void test01() {
		ApplicationContext ctx = getApplicationContext();
		ArithmicCalculator calculator = ctx.getBean(ArithmicCalculator.class);
		int result = calculator.add(3, 6);
		System.out.println(result);
		result = calculator.div(12, 6);
		System.out.println(result);
	}
}
