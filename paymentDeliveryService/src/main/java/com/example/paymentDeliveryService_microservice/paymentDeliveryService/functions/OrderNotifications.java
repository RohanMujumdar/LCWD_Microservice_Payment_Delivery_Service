package com.example.paymentDeliveryService_microservice.paymentDeliveryService.functions;

import com.example.paymentDeliveryService_microservice.paymentDeliveryService.dto.OrderDto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;


import java.util.function.Consumer;

@Configuration
public class OrderNotifications {

    @Autowired
    private StreamBridge streamBridge;

    @Bean
    public Consumer<Message<OrderDto>> orderRecieved()
    {

        return message -> {

            OrderDto orderDto = message.getPayload();
            System.out.println("Order has been recieved");
            System.out.println("delivery process started");
            System.out.println("Order Id: "+ orderDto.getId());
            sendAcknowledgement();
        };
    }


    public String sendAcknowledgement()
    {
        Message<String> message = MessageBuilder.withPayload("Thank you for the purchase").build();
        streamBridge.send("orderAcknowledgement-out-1", message);
        System.out.println("Acknowledgment message called");

        return "Thank you for the purchase.";
    }
}
