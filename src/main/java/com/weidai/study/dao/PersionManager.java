package com.weidai.study.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.weidai.study.entity.Person;


/**
 * @描述
 * @author nic 
 * @time：2018年6月1日 下午2:44:26
 */
@Repository
public class PersionManager {

	@Autowired
	PersonDao persiondao;
	
	@Transactional(value="transactionManager",isolation=Isolation.READ_UNCOMMITTED)
	public void insert() {
		for (int i=0 ; i< 100; i++) {
			Person p = new Person();
			p.setName("name" + i);
			p.setAge(i+100);
			persiondao.insert(p);
//			if (i>90)
//				throw new RuntimeException("ddd");
		}
	}
	
	public List<Person> query() {
		return persiondao.query();
	}
}
