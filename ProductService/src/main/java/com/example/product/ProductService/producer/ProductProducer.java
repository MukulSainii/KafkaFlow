package com.example.product.ProductService.producer;

import com.example.product.ProductService.modal.ProductReserved;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductProducer {
    private final KafkaTemplate<String, ProductReserved> kafkaTemplate;

    public ProductProducer(
            KafkaTemplate<String, ProductReserved> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendProductReserved(ProductReserved event) {

        kafkaTemplate.send(
                "product-events",
                event.getOrderId(),
                event
        );

        System.out.println(
                "ProductReserved event published"
        );
    }
}
