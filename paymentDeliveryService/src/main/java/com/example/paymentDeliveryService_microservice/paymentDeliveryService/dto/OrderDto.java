package com.example.paymentDeliveryService_microservice.paymentDeliveryService.dto;


//import com.example.paymentDeliveryService_microservice.paymentDeliveryService.entity.OrderItem;
import com.example.paymentDeliveryService_microservice.paymentDeliveryService.entity.OrderStatus;
import com.example.paymentDeliveryService_microservice.paymentDeliveryService.entity.PaymentMode;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {

    private String id;
    private String customerId;
//    private List<OrderItem> items;
    private Double totalAmount;
    private OrderStatus status;
    private String deliveryAddress;
    private PaymentMode paymentMode = PaymentMode.UPI;

}
