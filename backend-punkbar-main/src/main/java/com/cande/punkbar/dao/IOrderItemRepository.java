package com.cande.punkbar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cande.punkbar.entity.OrderItem;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
