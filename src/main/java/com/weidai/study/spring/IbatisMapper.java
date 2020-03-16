package com.weidai.study.spring;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 *
 * 如何将mapper 映射到 mapper.xml
 * @author lianghong.tlh
 * @date 2020/03/17
 */
public class IbatisMapper {

    public static void main(String[] args) throws Exception {

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://tddl.daily.alibaba.net:3306/RHINO_SUPPLYCHAIN_APP");
        druidDataSource.setUsername("RHINO_SUPPLYCHAIN_APP");
        druidDataSource.setPassword("123456");
        druidDataSource.init();

        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(druidDataSource);
        Resource[] resources = {new ClassPathResource("sqlmapper/mapper1.xml"),
            new ClassPathResource("sqlmapper/mapper2.xml")};
        factoryBean.setMapperLocations(resources);
        SqlSessionFactory factory = factoryBean.getObject();
        // 通过mappere registry注册
        factory.getConfiguration().addMapper(StudentMapper.class);

        MapperFactoryBean<StudentMapper> mapperFactoryBean = new MapperFactoryBean<>();
        mapperFactoryBean.setMapperInterface(StudentMapper.class);
        mapperFactoryBean.setSqlSessionFactory(factoryBean.getObject());
        StudentMapper studentMapper = mapperFactoryBean.getObject();
        studentMapper.insert(new Person());
    }

}
