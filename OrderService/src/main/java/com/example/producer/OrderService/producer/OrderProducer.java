package com.example.producer.OrderService.producer;

import com.example.producer.OrderService.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private final KafkaTemplate<String, Order> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Order order) {

        kafkaTemplate.send(
                "order-events",
                order.getOrderId(),
                order
        );

        System.out.println("Order published: " + order.getOrderId());
    }
}
