package com.weidai.study.parttendesign.proxy;

import java.io.File;
import java.io.FileOutputStream;

import sun.misc.ProxyGenerator;


/**
 * @描述  静态代理类
 * @author nic 
 * @time：2018年6月9日 上午1:41:04
 */
public class Huangniu implements Person {

	private Person  person = new ProgramerCoder();
	@Override
	public void buyTicket() {
		person.buyTicket();
	}

	
	public static void main(String[] args) throws Exception {
		Person  huangniu = new Huangniu();
		huangniu.buyTicket();
		
		Person obj = (Person) new GaojiHuangniu().getInstance(new ProgramerCoder());
		obj.buyTicket();
		//原理：
		// 1. 拿到代理对象的引用，获取到他的接口
		// 2. JDK 重新生成一个类，同时实现我门给的代理对象所实现的接口。
		// 3. 把被代理对象的引用也拿到。
		// 4. 重新动态生成一个class 字节码
		// 5. 编译
		
		// 下载动态生成的 代理可以看出会生成一个动态代理的类。这个类继承Proxy, 并实现Person接口。
		// 每个接口方法 通过调用代理类的 invoke 方法 来执行被代理的方法。
//		byte[] data =  ProxyGenerator.generateProxyClass("$Proxy0", new Class []{obj.getClass()});
//		FileOutputStream fos = new FileOutputStream(new File("~/Documents/$Proxy0.class"));
//		fos.write(data);
//		fos.flush();
//		fos.close();
	}
}
