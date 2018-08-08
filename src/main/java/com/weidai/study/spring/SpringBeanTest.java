package com.weidai.study.spring;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SpringBeanTest {

	public static void main(String[] args) throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybiatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
}
