package com.weidai.study.parttendesign.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
 * @描述
 * @author nic 
 * @time：2018年6月9日 下午2:34:48
 */
public class CGProxy  implements MethodInterceptor {

	private Object target;
	
	public Object getInstance(Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	@Override
	public Object intercept(Object target, Method m, Object[] arg2,
			MethodProxy proxy) throws Throwable {
		System.out.println("我是cglib 代理黄牛....");
		Object res = proxy.invokeSuper(target, arg2);
		System.out.println("买票成功，收服务费100元");
		return res;
	}

	public static void main(String[] args) {
		
		JavaCoder coder = (JavaCoder) new CGProxy().getInstance(new JavaCoder());
		coder.buyTicket();
		
	}
	
}
