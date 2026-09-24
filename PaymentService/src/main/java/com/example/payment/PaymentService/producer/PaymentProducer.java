package com.example.payment.PaymentService.producer;

import com.example.payment.PaymentService.modal.PaymentCompleted;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {
    private final KafkaTemplate<String, PaymentCompleted> kafkaTemplate;

    public PaymentProducer(
            KafkaTemplate<String, PaymentCompleted> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(PaymentCompleted event) {

        kafkaTemplate.send(
                "payment-events",
                event.getOrderId(),
                event
        );

        System.out.println(
                "PaymentCompleted event published"
        );
    }

}
