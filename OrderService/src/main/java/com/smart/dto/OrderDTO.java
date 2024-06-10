package com.smart.dto;

import java.math.BigDecimal;
import java.util.List;

import com.smart.model.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {
	
	private List<OrderLineItemsDTO> oredrLineItemsDto;

}
