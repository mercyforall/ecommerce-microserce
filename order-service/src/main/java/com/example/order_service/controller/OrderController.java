package com.example.order_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
@Autowired
private OrderService orderService;
@Autowired
private OrderRepository orderRepository;

@PostMapping
public CompletableFuture<OrderDTO> placeOrder(@RequestBody OrderDTO dto) {
    return orderService.placeOrder(dto);
}
