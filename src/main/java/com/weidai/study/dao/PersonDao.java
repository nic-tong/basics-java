package com.weidai.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.weidai.study.entity.Person;


/**
 * @描述
 * @author nic 
 * @time：2018年6月1日 下午2:39:58
 */
public interface PersonDao {

	@Insert("insert into tb_example(name,age) values(#{name}, #{age})")
	public void insert(Person person);
	
	@Select("Select * from tb_example")
	public List<Person> query();
}
