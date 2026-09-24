package com.example.payment.PaymentService.consumer;

import com.example.payment.PaymentService.modal.PaymentCompleted;
import com.example.payment.PaymentService.modal.ProductReserved;
import com.example.payment.PaymentService.producer.PaymentProducer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {
    private final PaymentProducer paymentProducer;

    public PaymentConsumer(PaymentProducer paymentProducer) {
        this.paymentProducer = paymentProducer;
    }

    @KafkaListener(
            topics = "product-events",
            groupId = "payment-service"
    )
    public void consume(ProductReserved event) {

        System.out.println(
                "Payment Service received order: "
                        + event.getOrderId()
        );

        // Payment processing

        System.out.println(
                "Payment successful for order: "
                        + event.getOrderId()
        );

        PaymentCompleted payment =
                new PaymentCompleted(
                        event.getOrderId(),
                        "SUCCESS"
                );

        paymentProducer.send(payment);
    }
}
