package com.example.producer.OrderService.controller;

import com.example.producer.OrderService.model.Order;
import com.example.producer.OrderService.producer.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {

        order.setOrderId(UUID.randomUUID().toString());

        orderProducer.sendOrder(order);

        return "Order created: " + order.getOrderId();
    }
}
