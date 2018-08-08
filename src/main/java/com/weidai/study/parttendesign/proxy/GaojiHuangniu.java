package com.weidai.study.parttendesign.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * @描述  jdk 动态代理
 * @author nic 
 * @time：2018年6月9日 上午1:58:12
 */
public class GaojiHuangniu implements MyInvocationHandler {

	private Object target;
	
	public Object getInstance(Object person) throws Exception {
		this.target = person;
		Class<?> clazz = person.getClass();
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
		
		Person obj = (Person) new GaojiHuangniu().getInstance(new ProgramerCoder());
		obj.buyTicket();
	}
}
