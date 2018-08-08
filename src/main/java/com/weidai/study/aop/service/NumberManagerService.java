package com.weidai.study.aop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * @描述
 * @author nic 
 * @time：2018年6月14日 下午9:08:58
 */
@Service
public class NumberManagerService {

	private static Logger logger = LoggerFactory.getLogger(NumberManagerService.class);
	
	public void create(int id) {
		System.out.println("add id.");
	}
	
	
	public void delete(int id) {
		logger.info("delete this id");
	}
	
	public int read(int id) {
		logger.info("read id");
		return 1;
	}
	
	public int update(int id) throws Exception{
		logger.info("update id");
		throw new Exception("");
	}
}
