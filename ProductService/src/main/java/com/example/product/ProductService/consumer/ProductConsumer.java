package com.example.product.ProductService.consumer;

import com.example.product.ProductService.modal.Order;
import com.example.product.ProductService.modal.ProductReserved;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.product.ProductService.producer.ProductProducer;

@Service
public class ProductConsumer {
    @Autowired
    private ProductProducer productProducer;
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

        ProductReserved paymentEvent = new ProductReserved(
                order.getOrderId(),
                order.getProductId()
        );
        productProducer.sendProductReserved(paymentEvent);
    }
}
