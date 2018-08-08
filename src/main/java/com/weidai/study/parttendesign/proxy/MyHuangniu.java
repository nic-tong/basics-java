package com.weidai.study.parttendesign.proxy;

import java.lang.reflect.Method;


/**
 * @描述
 * @author nic 
 * @time：2018年6月9日 下午1:00:13
 */
public class MyHuangniu implements MyInvocationHandler {


	private Object target;
	
	public Object getInstance(Object target) throws Exception {
		this.target = target;
		Class<?> clazz = target.getClass();
		System.out.println("被代理对象的class 是:" + clazz.getSimpleName());
		Object obj= MyProxy.newProxyInstance(new MyClassLoader(), clazz.getInterfaces(), this);
		System.out.println("代理对象的class 是:" + obj.getClass().getName());
		return obj;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("我是黄牛，你有的需求我来满足 请说：");
		Object result = method.invoke(target, args);
		System.out.println("服务完成，请付服务费100元.");
		return result;
	}

	public static void main(String[] args) throws Exception {
		Person person = (Person)new MyHuangniu().getInstance(new ProgramerCoder());
		person.buyTicket();
	}
}
