package cn.zhang.test;

import org.junit.Test;

import cn.zhang.bean.ArithmicCalculator;
import cn.zhang.bean.ArithmicCalculatorImp;
import cn.zhang.bean.ArithmicCalculatorProxy;

public class TestDynamicProxy {

	/**
	 * 使用动态代理的方式进行 AOP的简单实现
	 */
	@Test
	public void test01() {
		ArithmicCalculator target = new ArithmicCalculatorImp();
		ArithmicCalculator proxy = new ArithmicCalculatorProxy(target).getProxy();
		System.out.println(proxy.getClass());
		int result = proxy.add(1, 2);
		System.out.println(result);
	}
}
