package com.bank.service_payment.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePaymentDTO {
    private Long userId;
    private Integer serviceId;
    private Long accountId;
    private BigDecimal amount;
    private BigDecimal fee;
    private String referenceNumber;
    private String barcode;
}
