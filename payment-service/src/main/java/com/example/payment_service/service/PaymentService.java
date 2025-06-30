package com.example.payment_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.payment_service.dto.PaymentDTO;
import com.example.payment_service.entity.Payment;
import com.example.payment_service.repository.PaymentRepository;
import com.netflix.discovery.converters.Auto;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;        // Assuming you have a Kafka template for messaging

    public PaymentDTO process (PaymentDTO dto)
    {
            Payment payment = new Payment();
            payment.setOrderId(dto.getOrderId());
        payment.setAmount(dto.getAmount());
        payment.setStatus("PAID");
        payment.setPaymentDate(LocalDateTime.now());
        Payment saved = paymentRepository.save(payment);


        PaymentDTO response = new PaymentDTO(saved.getId(), saved.getOrderId(), saved.getAmount(), saved.getStatus(), saved.getPaymentDate());
            
        // Send payment information to Kafka topic
            kafkaTemplate.send("payment-processed", response);

            return response;
    }


    // Add methods to handle payment operations, e.g., create, update, delete payments
    // Example: public Payment createPayment(Payment payment) { return paymentRepository.save(payment);



    

}
