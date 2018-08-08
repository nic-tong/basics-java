package com.weidai.study.kafka;

import java.util.Collections;
import java.util.Random;

import kafka.utils.ShutdownableThread;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;


/**
 * @描述 实际消费者,继承了ShutdownableThread
 * @author nic 
 * @time：2018年4月25日 下午5:20:47
 */
public class Consumer extends ShutdownableThread {

    /**
     * kafka 消费者
     */
    private  KafkaConsumer<Integer, String> consumer;

    /**
     *  topic
     */
    private  String topic;

    /**
     *  组id
     */
    private  String groupId;
    
    private volatile boolean cancel = false;

    
    public Consumer(ConsumerGroup consumerGroup) {
        super("",false);
        this.consumer = consumerGroup.getConsumer();
        this.setTopic(consumerGroup.getTopic());
        this.setGroupId(consumerGroup.getA_groupId());
    }
    
    
    
    /**
     * 取消订阅主题，并关闭消费者
     */
    public void unsubscribe() {
    	consumer.unsubscribe();
		consumer.close();
        this.isRunning().set(false);
    }

    /**
     *  * 监听主题,有消息就读取
     * 从kafka里面得到数据后,具体怎么去处理. 如果需要开启kafka处理消息的广播模式,多个监听要监听不同的group,
     * 即方法上的注解@KafkaListener里的group一定要不一样.如果多个监听里的group写的一样,就会造成只有一个监听能处理其中的消息,
     * 另外监听就不能处理消息了.也即是kafka的分布式消息处理方式.
     * 在同一个group里的监听,共同处理接收到的消息,会根据一定的算法来处理.如果不在一个组,但是监听的是同一个topic的话,就会形成广播模式
     */
    @Override
    public void doWork() {
    	if (cancel) {
    		unsubscribe();
    		return;
    	}
        consumer.subscribe(Collections.singletonList(this.getTopic()));
        ConsumerRecords<?, String> records = consumer.poll(1000);
        for (ConsumerRecord<?, String> record : records) {
            System.out.println("Thread: "+Thread.currentThread().getName()
                    +"Received message: (" + this.groupId + ", " + record.value() + ") at offset "
                    + record.offset()+" partition : "+records.partitions());
        }
    }

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}



	public boolean isCancel() {
		return cancel;
	}



	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}
}
