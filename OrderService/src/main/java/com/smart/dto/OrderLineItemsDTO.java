package com.smart.dto;

import java.math.BigDecimal;

import com.smart.model.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class OrderLineItemsDTO {
	
	private int id;
	private String skuCode;
	private BigDecimal price;
	private int quantity;

}
