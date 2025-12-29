package com.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.app.model.Order;

@Service
public class KafkaOrderProducerServiceImpl implements KafkaOrderProducerService {
	
	@Autowired
	private KafkaTemplate<String, Object> kafaKafkaTemplate;
	
	@Override
	public boolean placeOrder(Order order) {
		
		try {
			if(order.getOrderId() == null || order.getOrderId().trim().isEmpty()) {
				order.setOrderId(String.valueOf(System.nanoTime()));
			}
			order.setOrderDate(new Date());
			
			kafaKafkaTemplate.send("order-topic", order.getOrderId(), order);
			
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

}
