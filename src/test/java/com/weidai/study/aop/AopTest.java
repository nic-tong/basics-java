package com.weidai.study.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.weidai.study.aop.service.NumberManagerService;


/**
 * @描述
 * @author nic 
 * @time：2018年6月14日 下午9:31:08
 */
@ContextConfiguration(locations = {"classpath:application-aop.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AopTest {

	@Autowired NumberManagerService numberMangerService;
	
	@Test
	public void testAdd() {
		numberMangerService.create(0);
	}
	
}
