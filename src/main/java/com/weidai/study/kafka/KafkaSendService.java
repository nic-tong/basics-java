package com.weidai.study.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * @描述
 * @author nic 
 * @time：2018年4月25日 下午6:55:45
 */
@Component
public class KafkaSendService {


    @Autowired
    private KafkaSender kafkaSender;
	
    //然后每隔1分钟执行一次
    @Scheduled(fixedRate = 1000 * 30)
    public void testKafka() throws Exception {
        kafkaSender.sendTest();
    }
}
