package com.weidai.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @描述
 * @author nic 
 * @time：2018年4月25日 下午5:15:16
 */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
//@EnableScheduling
@EnableTransactionManagement
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application .class, args);
    }
}