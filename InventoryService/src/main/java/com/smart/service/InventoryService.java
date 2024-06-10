package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smart.repository.InventoryRepo;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepo inventoryRepo;
	public boolean isInStock(String skuCode) {
		
		return inventoryRepo.findBySkuCode().isPresent();
	}

}
