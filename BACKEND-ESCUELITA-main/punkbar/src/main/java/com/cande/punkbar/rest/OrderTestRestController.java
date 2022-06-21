package com.cande.punkbar.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.entity.OrderTest;
import com.cande.punkbar.service.OrderTestService;

@RestController
@RequestMapping("/ordertest")
public class OrderTestRestController {

	private OrderTestService orderTestService;
	
	public OrderTestRestController(OrderTestService theOrderTestService) {
		orderTestService = theOrderTestService;
	}
	
	@GetMapping("/ordertest/all")
	public List<OrderTest> findAll(){
		return orderTestService.findAll();
	}
	
	@GetMapping("/ordertest")
	public OrderTest findById(@RequestParam int theId) {
		OrderTest order = orderTestService.findById(theId);
		if(order == null) {
			throw new RuntimeException("Order id not found: " + theId);
		}
		return order;
	}
	
	@PostMapping("/ordertest")
	public OrderTest addOrderTest(@RequestBody OrderTest theOrderTest) {
		
		theOrderTest.setIdOrder(0);
		orderTestService.save(theOrderTest);
		
		return theOrderTest;
	}
	
	@PutMapping("/ordertest")
	public OrderTest updateOrderTest(@RequestBody OrderTest theOrderTest) {
		orderTestService.save(theOrderTest);
		return theOrderTest;
	}
	
}
