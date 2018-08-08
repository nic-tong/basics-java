package com.weidai.study.kafka;

import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;


/**
 * @描述
 * @author nic 
 * @time：2018年4月25日 下午5:21:45
 */
public class ConsumerGroup  {

    /**
     *  日志处理
     */
    private static final Log log = LogFactory.getLog(ConsumerGroup.class);

    /**
     *  topic
     */
    private final String topic;
    
    private String autoOffsetReset;

    /**
     *  公共连接属性
     */
    private  Properties props ;

    /**
     * 消费者组
     */
    private final String groupId;

    
    public ConsumerGroup(String groupId, String topic, KafkaConsumerConfig consumerConfig, String autoOffsetReset) {
        if (org.springframework.util.StringUtils.isEmpty(autoOffsetReset))
        	autoOffsetReset = "earliest";
    	// 默认从头开始消费
    	createConsumerConfig(groupId,consumerConfig, autoOffsetReset);
        this.setAutoOffsetReset("earliest");
        this.topic = topic;
        this.groupId = groupId;
    }


    private Properties createConsumerConfig(String groupId, KafkaConsumerConfig consumerConfig, String autoOffsetReset) {
        props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,consumerConfig.servers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, consumerConfig.enableAutoCommit);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, consumerConfig.autoCommitInterval);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, consumerConfig.sessionTimeout);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        // 其他配置再配置
        return props;
    }

    public KafkaConsumer<Integer,String> getConsumer() {
        return new KafkaConsumer<Integer, String>(props);
    }

    /**
     *  其他类获取topic
     * @return
     */
    public String getTopic() {
        return topic;
    }

    public String getA_groupId() {
        return groupId;
    }


	public String getAutoOffsetReset() {
		return autoOffsetReset;
	}


	public void setAutoOffsetReset(String autoOffsetReset) {
		this.autoOffsetReset = autoOffsetReset;
	}
}