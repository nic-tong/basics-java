package com.weidai.study.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.weidai.study.kafka.Consumer;
import com.weidai.study.kafka.ConsumerGroup;
import com.weidai.study.kafka.KafkaConsumerConfig;
import com.weidai.study.kafka.KafkaConsumerPool;


/**
 * @描述
 * @author nic 
 * @time：2018年4月25日 下午7:39:00
 */
@Controller
@RequestMapping("kafka")
public class KafkaController {

	   @Resource
	   KafkaConsumerPool consumerPool;
	   
	   @Resource
	   KafkaConsumerConfig consumerConfig;
	   
	   @RequestMapping("/addConsumer")
	   @ResponseBody
	   public String addConsumer(String topic, String groupId, String autoOffsetReset){
		   ConsumerGroup consumerThread = new ConsumerGroup(groupId,topic,consumerConfig,autoOffsetReset);
		   consumerPool.SubmitConsumerPool(new Consumer(consumerThread));
		   return "SUCCESS";
	   }
	   
	   @RequestMapping("/removeConsumer")
	   @ResponseBody
	   public String removeConsumer(String topic, String groupId){
		   consumerPool.unsubscribe(topic, groupId);
		   return "SUCCESS";
	   }
	
}
