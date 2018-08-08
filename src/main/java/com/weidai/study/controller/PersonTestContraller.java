package com.weidai.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.weidai.study.dao.PersionManager;
import com.weidai.study.entity.Person;


/**
 * @描述
 * @author nic 
 * @time：2018年6月1日 下午2:43:27
 */
@Controller
@RequestMapping("/person")
public class PersonTestContraller {

	@Autowired
	PersionManager manager;
	

	   @RequestMapping("/insert")
	   @ResponseBody
	   public String addConsumer(){
		   manager.insert();
		   return "SUCCESS";
	   }
	   
	   @RequestMapping("/query")
	   @ResponseBody
	   public String query(){
		   List<Person> list = manager.query();
		   return JSON.toJSONString(list);
	   }
}
