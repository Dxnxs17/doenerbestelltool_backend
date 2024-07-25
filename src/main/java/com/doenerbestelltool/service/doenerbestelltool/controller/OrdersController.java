package com.doenerbestelltool.service.doenerbestelltool.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doenerbestelltool.service.doenerbestelltool.dto.OrderDto;
import com.doenerbestelltool.service.doenerbestelltool.entity.OrderEntity;
import com.doenerbestelltool.service.doenerbestelltool.service.OrderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrdersController {

	@Autowired
	OrderService orderService;

	@GetMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	List<OrderEntity> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
	OrderEntity getOrderById(@RequestParam(required = true) Integer id) {
		return orderService.getOrderById(id);
	}

	@PostMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
	OrderEntity createOrder(@RequestParam(required = true) String cusForename,
			@RequestParam(required = true) String cusSurename,
			@RequestParam(required = true, defaultValue = "Döner") String product,
			@RequestParam(required = true) String price,
			@RequestParam(required = true, defaultValue = "1") Integer size,
			@RequestParam(required = true) String sauce1, @RequestParam(required = true) String sauce2,
			@RequestParam(required = true) String meat, @RequestParam(required = false) String specialWishes,
			@RequestParam(required = false) String specialInstruction,
			@RequestParam(required = true, defaultValue = "2024-03-18") LocalDateTime orderDate) {
		return orderService.createOrder(cusForename, cusSurename, product, price, size, sauce1, sauce2, meat,
				specialWishes, specialInstruction, orderDate);
	}

	@PostMapping("/createOrder")
	public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDTO) {
		OrderDto savedOrder = orderService.saveOrder(orderDTO);
		return ResponseEntity.ok(savedOrder);
	}

}
