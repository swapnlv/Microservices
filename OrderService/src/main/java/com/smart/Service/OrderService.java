package com.smart.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.Repository.OrderRepo;
import com.smart.dto.OrderDTO;
import com.smart.dto.OrderLineItemsDTO;
import com.smart.model.Order;
import com.smart.model.OrderLineItems;

@Service
public class OrderService {
	
	@Autowired
	OrderRepo orderrepo;
	
	public void createOrder(OrderDTO orderDto) {
		
		
		Order order =new Order();
		
		order.setOrderNumber(UUID.randomUUID().toString());
		
		List<OrderLineItems> orderLineItems=(List<OrderLineItems>) orderDto.getOredrLineItemsDto().stream().map(orderLineItemsDto->mapToOrderDto(orderLineItemsDto)).toList();
		
		order.setOrderLineItems(orderLineItems);
		
		orderrepo.save(order);
		
	}

	private OrderLineItems mapToOrderDto(OrderLineItemsDTO orderLineItemsDTO) {
		// TODO Auto-generated method stub
		
		OrderLineItems oredrLineItems=OrderLineItems.builder().id(orderLineItemsDTO.getId())
			                .skuCode(orderLineItemsDTO.getSkuCode()).
			                 quantity(orderLineItemsDTO.getQuantity())
			                 .price(orderLineItemsDTO.getPrice()).build();
			                 return oredrLineItems;
	}
	
	

}
