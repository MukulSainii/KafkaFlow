package com.example.Consumer.NotificationService.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaymentCompleted {
    private String orderId;
    private String status;

}
