package com.cande.punkbar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cande.punkbar.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
