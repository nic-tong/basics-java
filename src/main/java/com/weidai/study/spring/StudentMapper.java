package com.weidai.study.spring;

/**
 * @author lianghong.tlh
 * @date 2020/03/17
 */
public interface StudentMapper {


    Person select(Long id);

    int insert(Person person);


    int update(Person person);

}
