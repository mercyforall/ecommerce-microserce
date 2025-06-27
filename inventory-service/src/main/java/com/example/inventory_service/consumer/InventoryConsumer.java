package com.example.inventory_service.consumer;


import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.inventory_service.service.InventoryService;
import com.netflix.discovery.converters.Auto;

@Component   // This annotation indicates that this class is a Spring component, allowing it to be automatically detected and registered as a bean in the Spring application context.
public class InventoryConsumer {
    
    @Autowired
    private InventoryService inventoryService;  // This field is automatically injected with an instance of InventoryService, which is used to interact with the inventory data.
    
    @KafkaListener(topics = "order-created", groupId = "inventory-group")    // This annotation configures the method to listen for messages on the "order-created" Kafka topic, using the "inventory-group" consumer group.
    public void handleOrderCreated(OrderDto order) {
        order.getProductIds().forEach(productId -> {
            new Thread(() -> inventoryService.decreaseStock(productId, order.getQuantity()))
                    .start();  // For each product ID in the order, a new thread is started to decrease the stock in the inventory service.
        });
    }


}

