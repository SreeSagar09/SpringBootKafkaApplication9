package com.app.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.app.model.Order;

public interface KafkaOrderConsumerService {
	public void processOrder(ConsumerRecord<String, Object> consumerRecord);
}
