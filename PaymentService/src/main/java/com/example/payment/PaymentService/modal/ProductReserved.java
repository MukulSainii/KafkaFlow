package com.example.payment.PaymentService.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class ProductReserved {
    private String orderId;
    private String productId;
}
