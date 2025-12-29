package com.app.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.app.model.Order;

@Service
public class KafkaOrderConsumerServiceImpl implements KafkaOrderConsumerService {
	
	@KafkaListener(topics = "order-topic", groupId = "group-1", containerFactory = "concurrentKafkaListenerContainerFactory")
	@Override
	public void processOrder(ConsumerRecord<String, Object> consumerRecord) {
		
		try {
			Order order = (Order)consumerRecord.value();
			order.setOrderProcessedBy("processOrder1[group-1]");
			System.out.println(order);
		} catch (Exception e) {
			throw e;
		}
	}
	
}
