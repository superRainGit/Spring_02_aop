package cn.zhang.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmicCalculatorProxy {

	private ArithmicCalculator target;
	
	public ArithmicCalculatorProxy(ArithmicCalculator target) {
		this.target = target;
	}
	
	public ArithmicCalculator getProxy() {
		ArithmicCalculator proxy = null;
		ClassLoader loader = target.getClass().getClassLoader();
		Class<?>[] interfaces = new Class<?>[]{ArithmicCalculator.class};
		InvocationHandler h = new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				String methodName = method.getName();
				System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
				Object result = null;
				try {
					// 前置通知  当方法执行前进行的通知
					result = method.invoke(target, args);
					// 返回通知  当方法正确放回时才会执行的操作 可以访问到对应的返回值
				} catch (NullPointerException e) {
					e.printStackTrace();
					// 异常通知   因为catch语句可以指定为更加详细的异常  因此可以
					// 指定异常通知的时候   指定发生哪个异常再执行指定的方法
					throw e;
				} finally {
					// 后置通知  因为方法执行的过程中可能发生异常  所以访问不到方法的返回值 
					System.out.println("The method " + methodName + " ends with " + result);
				}
				return result;
			}
		};
		proxy = (ArithmicCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;
	}
}
