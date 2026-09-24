package com.example.payment.PaymentService.modal;

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
