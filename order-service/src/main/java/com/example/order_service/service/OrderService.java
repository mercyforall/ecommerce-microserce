package com.example.order_service.service;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.order_service.entity.Order;
import com.example.order_service.repository.OrderRepository;
import com.netflix.discovery.converters.Auto;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @Async
    public CompletableFuture<OrderDTO> placeOrder(OrderDTO dto)
    {
        Order order = new Order();
        order.setUserId(dto.getUserId());
        order.setProductIds(dto.getProductIds());
        order.setTotalAmount(dto.getTotalAmount());
        order.setOrderDate(LocalDateTime.now());
        Order saved = orderRepository.save(order);

        orderDTO saveDto = new orderDTO(saved.getId(), saved.getUserId(), saved.getProductIds(), saved.getTotalAmount(), saved.getOrderDate());

        kafkaTemplate.send("order-created", saveDto);  // Send order created event to Kafka
        return CompletableFuture.completedFuture(saveDto);
     }

}
