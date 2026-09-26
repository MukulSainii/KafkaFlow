package com.example.Consumer.NotificationService.consumer;

import com.example.Consumer.NotificationService.modal.PaymentCompleted;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {
    @KafkaListener(
            topics = "payment-events",
            groupId = "notification-service"
    )
    public void consume(PaymentCompleted event) {

        System.out.println(
                "Notification Service received event"
        );

        System.out.println(
                "Order ID: " + event.getOrderId()
        );

        System.out.println(
                "Payment Status: " + event.getStatus()
        );

        System.out.println(
                "Sending notification to customer..."
        );
    }
}
