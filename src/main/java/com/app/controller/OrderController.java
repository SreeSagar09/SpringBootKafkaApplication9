package com.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Order;
import com.app.service.KafkaOrderProducerService;

@RestController
@RequestMapping(path = "/order")
public class OrderController {
	@Autowired
	private KafkaOrderProducerService kafkaOrderProducerService;
	
	@PostMapping(path = "/placeOrder")
	public ResponseEntity<Map<String, Object>> placeOrder(@RequestBody Order order) {
		ResponseEntity<Map<String, Object>> responseEntity = null;
		try {
			boolean isOrderPlaced = kafkaOrderProducerService.placeOrder(order);
			
			if(isOrderPlaced) {
				responseEntity = new ResponseEntity<>(Map.of("description", "Order placed successfully.", "orderId", order.getOrderId()), HttpStatus.OK);
			}else {
				responseEntity = new ResponseEntity<>(Map.of("description", "Order placed failed."), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}
	
}
