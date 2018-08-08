package com.weidai.study.parttendesign.proxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * @描述 将二进制文件 load 到jvm中 生成对象
 * @author nic 
 * @time：2018年6月9日 上午11:40:53
 */
public class MyClassLoader extends ClassLoader {

	private File baseDir;
	
	public MyClassLoader() {
		String basePath = MyClassLoader.class.getResource("").getPath();
		this.baseDir = new File(basePath);
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// 通过包名找到代理完整的类名
		String className = 
		MyClassLoader.class.getPackage().getName() + "." + name;
		if (baseDir != null) {
			// 找到二进制类文件所在的位置
			File classFile = new File(baseDir,name.replaceAll("\\.", "/") + ".class");
			if (classFile.exists()) {
				FileInputStream in = null;
				try {
					in = new FileInputStream(classFile);
					ByteArrayOutputStream out = new ByteArrayOutputStream();
					byte [] buff = new byte[1024];
					int len;
					while ((len = in.read(buff)) != -1) {
						out.write(buff, 0, len);
					}
					// 通过二进制流将类加载到jvm中
					return defineClass(className, out.toByteArray(),0,  out.size());
				} catch (Exception e){
					
				} finally {
					if (null != in) {
						try {
							in.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
						
			}
		}
		return super.findClass(name);
	}
}
