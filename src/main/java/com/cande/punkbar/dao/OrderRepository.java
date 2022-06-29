package com.cande.punkbar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cande.punkbar.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
