package com.smart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.model.Order;

public interface OrderRepo extends JpaRepository<Order, Integer>{

}
