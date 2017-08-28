package cn.zhang.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 要想将一个POJO声明成为一个切面
 * @author zhang
 *
 */
@Order(2)
@Component
@Aspect
public class LoggingAspect {
	
	/**
	 * 定义一个方法  用于声明切入点表达式  一般的  该方法内部不要再加入其他的代码
	 * 使用 @Pointcut 注解来声明切入点表达式
	 * 在同一个切面中  想要使用共用的切入点表达式  进需要在@AspectJ 注解的value属性声明为声明切点的方法名:
	 * 		declareJoinPointExpression()
	 * 如果在同一个包中  要引用别的切面中的   就需要使用想要引用的那个切面的类名.声明切点的方法名
	 * 如果在不同的包内   就需要使用包名.类名.声明切点的方法名
	 */
	@Pointcut("execution(* cn.zhang.aop.impl.ArithmicCalculator.*(..))")
	public void declareJoinPointExpression() {}

	/**
	 * 使用@Before注解  表明是在指定的方法执行之前进行代码的插入
	 * 如果想要获取方法的详细信息
	 * 需要使用JoinPoint进行连接点对象的传入
	 */
	@Before("declareJoinPointExpression()")
	public void before(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		List<Object> args = Arrays.asList(jp.getArgs());
		System.out.println("The method " + methodName +" begins " + args);
	}
	
	/**
	 * 后置通知:在目标方法执行后(无论方法执行是否抛出异常)执行的通知
	 * 在后置通知中还不能访问目标方法执行的结果
	 */
	@After("execution(* cn.zhang.aop.impl.ArithmicCalculator.*(..))")
	public void after(JoinPoint jp) {
		String methodName = jp.getSignature().getName();
		System.out.println("The method " + methodName +" ends");
	}

	/**
	 * 在方法正常结束后执行的代码
	 * 返回通知是可以访问到返回值的
	 * @param jp
	 */
	@AfterReturning(value="execution(* cn.zhang.aop.impl.ArithmicCalculator.*(..))",
			returning="result")
	public void afterReturnning(JoinPoint jp, Object result) {
		String methodName = jp.getSignature().getName();
		System.out.println("The method " + methodName +" ends " + result);
	}

	/**
	 * 在方法抛出异常的时候执行的代码
	 * 可以访问到对应的异常对象
	 * 同时可以指定在抛出指定的异常的时候再执行通知的代码
	 * 例如可以指定通知的参数为NullPointerException来指定当目标方法发生空指针异常的时候再执行通知的方法
	 * @param jp
	 * @param ex
	 */
	@AfterThrowing(value="execution(* cn.zhang.aop.impl.ArithmicCalculator.*(..))",
			throwing="ex")
	public void afterThrowing(JoinPoint jp, NullPointerException ex) {
		String methodName = jp.getSignature().getName();
		System.out.println("The method " + methodName +" occurs exception : " + ex);
	}
	
	/**
	 * 环绕通知
	 * 类似于简单的动态代理
	 * 环绕通知必须要有一个返回值
	 * 同时必须要传入一个ProceedingJoinPoint对象用来表示链接
	 * @return
	 */
	@Around("execution(* cn.zhang.aop.impl.ArithmicCalculator.mmm(..))")
	public Object around(ProceedingJoinPoint pjd) {
		Object result = null;
		return result;
	}
	
}
