package com.example.payment.PaymentService.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductReserved {
    private String orderId;
    private String productId;
}
