package com.example.payment_service.dto;

import java.time.LocalDateTime;

public class PaymentDTO {
    private Long id;
    private Long orderId;
    private double amount;
    private String status;
    private LocalDateTime paymentDate;

    public PaymentDTO(Long id, Long orderId, double amount, String status, LocalDateTime paymentDate) {
        this.id = id;
        this.orderId = orderId;
        this.amount = amount;
        this.status = status;
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

}
