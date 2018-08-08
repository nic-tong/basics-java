package com.weidai.study.parttendesign.proxy;

import java.lang.reflect.Method;


/**
 * @描述
 * @author nic 
 * @time：2018年6月9日 上午11:39:36
 */
public interface MyInvocationHandler {

	 public Object invoke(Object proxy, Method method, Object[] args)
		        throws Throwable;
}
