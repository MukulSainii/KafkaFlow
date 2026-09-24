package com.example.product.ProductService.consumer;

import com.example.product.ProductService.modal.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductConsumer {
    @KafkaListener(
            topics = "order-events",
            groupId = "product-service"
    )
    public void consumeOrder(Order order) {

        System.out.println(
                "Product Service received order: "
                        + order.getOrderId()
        );

        System.out.println(
                "Reserving product: "
                        + order.getProductId()
        );

        System.out.println(
                "Quantity: "
                        + order.getQuantity()
        );

        // Product reservation logic here
    }
}
