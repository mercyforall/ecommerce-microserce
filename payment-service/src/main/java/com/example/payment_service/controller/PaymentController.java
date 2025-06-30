package com.example.payment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment_service.dto.PaymentDTO;
import com.example.payment_service.entity.Payment;
import com.example.payment_service.service.PaymentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService; // Assuming PaymentService is the service class for payment operations

    @PostMapping
    public PaymentDTO pay(@RequestBody PaymentDTO PaymentDTO dto) {
        // Process the payment and return the response
        return paymentService.process(dto);
    
    

}
