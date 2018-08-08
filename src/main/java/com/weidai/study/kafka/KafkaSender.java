package com.weidai.study.kafka;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.zookeeper.KeeperException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;


/**
 * @描述
 * @author nic 
 * @time：2018年4月25日 下午5:16:04
 */
@Component
public class KafkaSender {

    @Resource
    KafkaConsumerPool consumerPool;

    /**
     *  这里需要放到程序启动完成之后执行 TODO
     */
    @PostConstruct
    void d(){

        ConsumerGroup consumerThread = new ConsumerGroup("group-A","test1.example3",consumerConfig,null);
        ConsumerGroup consumerThread2 = new ConsumerGroup("group-B","test1.example3", consumerConfig,null);

        /**
         * 各起两个消费者 ,Kafka consumer是非线程安全的 Consumer 需要一个new 的
         */
//        consumerPool.SubmitConsumerPool(new Consumer(consumerThread));
//        consumerPool.SubmitConsumerPool(new Consumer(consumerThread));
//
//        consumerPool.SubmitConsumerPool(new Consumer(consumerThread2));
//        consumerPool.SubmitConsumerPool(new Consumer(consumerThread2));
    }


    @Resource
    KafkaConsumerConfig consumerConfig;

    @Autowired
    private KafkaTemplate<?, String> kafkaTemplate;


    /**
     * 发送消息到kafka
     *
     */
    public void sendTest() throws InterruptedException, IOException, KeeperException {

        /**
         * topic='access_data'
         */
    	JSONObject sendJson = new JSONObject();
    	/**{
    	    "columns": {
    	        "name": "9_yhq",
    	        "id": "1000",
    	        "age": "10"
    	    },
    	    "columnsType": {
    	        "name": "VARCHAR",
    	        "id": "INTEGER",
    	        "age": "INTEGER"
    	    },
    	    "eventType": "UPDATE",
    	    "executeTime": 1525228546000,
    	    "primaryKey": "id",
    	    "schema": "topic_name",
    	    "sendTime": 1525229019354,
    	    "table": "example3"
    	} */
    	String action = "INSERT";
    	for (int i=1000; i < 1002; i++) {
    		int id = i+2000;
    		int age = i-999;
    		if ("UPDATE".equals(action))
    			age = age+100;
	    	sendJson.put("eventType", action);
	    	sendJson.put("primaryKey", "id");
	    	sendJson.put("schema", "test1");
	    	sendJson.put("table", "example5");
	    	sendJson.put("executeTime", System.currentTimeMillis()-1000);
	    	sendJson.put("sendTime", System.currentTimeMillis());
	    	JSONObject columns = new JSONObject();
	    	columns.put("name", i+"_yhq");
	    	columns.put("id", String.valueOf(id));
	    	columns.put("age", String.valueOf(age));
	    	columns.put("age2", String.valueOf(age+1111));
	    	sendJson.put("columns", columns);
	    	JSONObject columnsType = new JSONObject();
	    	columnsType.put("name", "VARCHAR");
	    	columnsType.put("id", "INTEGER");
	    	columnsType.put("age", "INTEGER");
	    	columnsType.put("age2", "INTEGER");
	    	sendJson.put("columnsType", columnsType);
	    	kafkaTemplate.send("test1.example3", 1, sendJson.toJSONString());
    	}
    	System.out.println(action + "发送完毕");
//        kafkaTemplate.send("atest","发送时间"+System.currentTimeMillis());
//        kafkaTemplate.send("atest","发送时间"+System.currentTimeMillis());
    }
    
    public void sendInsert() {
    	
    }
    
    public void sendAlterTest() throws InterruptedException, IOException, KeeperException {
    	JSONObject sendJson = new JSONObject();
    	sendJson.put("eventType", "ALTER");
    	sendJson.put("columns", new JSONObject());
    	sendJson.put("columnsType", new JSONObject());
    	sendJson.put("table", "example5");
    	sendJson.put("executeTime", System.currentTimeMillis()-1000);
    	sendJson.put("sendTime", System.currentTimeMillis());
    	sendJson.put("sql", "alter table example5 change column age2 age3 int not null default 1;");
    	kafkaTemplate.send("test1.example3", 1, sendJson.toJSONString());
    	System.out.println("ALTER发送完毕");
    	sendJson.put("sql", "alter table example5 modify column name varchar(30);");
    	kafkaTemplate.send("test1.example3", 1, sendJson.toJSONString());
    	System.out.println("ALTER发送完毕");
    }


}
