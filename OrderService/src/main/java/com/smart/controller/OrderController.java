package com.smart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.smart.Service.OrderService;
import com.smart.dto.OrderDTO;

@RestController
@RequestMapping("/api/order")
public class OrderController {
	
	@Autowired
	OrderService orderServ;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String createOrder(@RequestBody OrderDTO orderDto ) {
		
		orderServ.createOrder(orderDto);
		return "Order placed Successfully!!! ";
	}

}
