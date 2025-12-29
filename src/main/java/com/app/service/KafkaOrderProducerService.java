package com.app.service;

import com.app.model.Order;

public interface KafkaOrderProducerService {
	public boolean placeOrder(Order order);
}
