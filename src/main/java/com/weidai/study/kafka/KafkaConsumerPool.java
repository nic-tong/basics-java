package com.weidai.study.kafka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import kafka.utils.ShutdownableThread;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


/**
 * @描述  kafka 消费池
 * @author nic 
 * @time：2018年4月25日 下午5:23:31
 */
@Component
public class KafkaConsumerPool {

    /**
     * 日志处理
     */
    private static final Log log = LogFactory.getLog(KafkaConsumerPool.class);

    /**
     *  线程池
     */
    private ExecutorService executor;
    Map<String,List<Consumer>> consumerMap = new HashMap<>();

    /**
     * 
     */
    @PostConstruct
    void init(){
        executor = Executors.newCachedThreadPool();
    }

    /**
     * 提交新的消费者
     *
     * @param shutdownableThread
     */
    public void SubmitConsumerPool(Consumer consumer) {
    	// 添加consumer到线程中
    	synchronized (consumerMap) {
    		String key = consumer.getTopic() + ":" + consumer.getGroupId();
			if (!consumerMap.containsKey(key)) {
				List<Consumer> consumers = new ArrayList<>();
				consumers.add(consumer);
				consumerMap.put(key, consumers);
			} else {
				List<Consumer> consumers = consumerMap.get(key);
				consumers.add(consumer);
				consumerMap.put(key, consumers);
			}
		}
        executor.execute(consumer);
    }

    /**
     * 程序关闭,关闭线程池
     *
     */
    @PreDestroy
    void fin(){
        shutdown();
    }

    public void shutdown() {
        if (executor != null) executor.shutdown();
        try {
            if (!executor.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                log.info("Timed out waiting for consumer threads to shut down, exiting uncleanly");
            }
        } catch (InterruptedException e) {
            log.info("Interrupted during shutdown, exiting uncleanly");
        }
    }
    
    public void unsubscribe(String topic, String groupId) {
    	String key = topic + ":" + groupId;
    	synchronized (consumerMap) {
    		List<Consumer> consumers = consumerMap.get(key);
    		if (null != consumers) {
    			consumers.forEach(consumer->{
    				consumer.setCancel(true);;
    			});
    			consumerMap.remove(key);
    		}
    	}
    }
}
