package com.example.notification_service.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.notification_service.dto.NotificationDTO;
import com.example.notification_service.service.NotificationService;

@Component
public class NotificationConsumer {

    @Autowired
    private NotificationService notificationService;

    @KafkaListener(topics = "notification-topic", groupId = "notification-group")
    public void handleOrder(NotificationDTO dto)  
    {
        notificationService.sendNotification(dto);
    }

    @KafkaListener(topics = "user-login", groupId = "notification-group")
    public void handleLogin(String email)
    {
        notificationService.sendNotification(new NotificationDTO("LOGIN", email, "Welcome back to MyShop!"));
    }
}