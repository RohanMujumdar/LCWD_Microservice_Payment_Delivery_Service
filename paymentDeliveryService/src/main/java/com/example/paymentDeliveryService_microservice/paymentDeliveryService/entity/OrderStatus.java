package com.example.paymentDeliveryService_microservice.paymentDeliveryService.entity;

public enum OrderStatus {
    PENDING,
    PLACED,
    PREPARING,
    READY,
    OUT_FOR_DELIVERY,
    DELIVERED,
    CANCELLED
}
