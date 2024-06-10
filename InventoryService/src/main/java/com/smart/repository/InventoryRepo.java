package com.smart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.model.Inventory;

public interface InventoryRepo extends JpaRepository<Inventory, Integer>{

	Optional<Inventory> findBySkuCode();

}
