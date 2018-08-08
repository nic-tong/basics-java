package com.weidai.study.parttendesign.proxy;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


/**
 * @描述  生成对象代理的方法
 * @author nic 
 * @time：2018年6月9日 上午11:40:11
 */
public class MyProxy {

	MyInvocationHandler h;
	private static final String ln = "\r\n";
	public static Object newProxyInstance(MyClassLoader myClassLoader,
			Class<?>[] interfaces, MyInvocationHandler h) {
		try {
		// 第一步生成源代码
		String proxySrc = genrateSrc(interfaces[0]);
		
		// 第二步 将生成的源代码保存到.java 文件
		
		String path = MyProxy.class.getResource("").getPath();
		File f = new File(path + "$Proxy0.java");
		FileWriter fw = new FileWriter(f);
		fw.write(proxySrc);
		fw.flush();
		fw.close();
		// 第三步  编译java 文件，生成 class 文件
		
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
		Iterable iterable = manager.getJavaFileObjects(f);
		
		CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
		task.call();
		manager.close();

		// 第四步  将class 文件内容 动态加载到jvm中
		Class<?> proxyClazz = myClassLoader.findClass("$Proxy0");
		
		// 第五步  返回生成的代理对象
		
		Constructor c = proxyClazz.getConstructor(MyInvocationHandler.class);
		return c.newInstance(h);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static String genrateSrc(Class<?> interfaces) {
		StringBuilder sb = new StringBuilder();
		sb.append("package com.weidai.study.parttendesign.proxy;" + ln);
		sb.append("import java.lang.reflect.Method;" + ln);
		sb.append("public final class $Proxy0 implements " + interfaces.getName() + "{"+ln);
		
		sb.append("MyInvocationHandler h;" + ln);
		
		
		sb.append("public $Proxy0(MyInvocationHandler h) {" + ln);
		sb.append("this.h = h;" + ln);
		sb.append("}" + ln);
		
		for (Method method : interfaces.getMethods()) {
			sb.append("public " + method.getReturnType() + " " + method.getName() + "() {" + ln);
			sb.append("try {" + ln);
			sb.append("Method m = " + interfaces.getName()+ ".class.getMethod(\""+ method.getName()+"\", new Class[]{});"+ln);
			sb.append("this.h.invoke(this, m, null);" + ln);
			
			sb.append("} catch(Throwable e){}");
			sb.append("}" + ln);
		}
		
		sb.append("}" + ln);
		return sb.toString();
	}
	
}
