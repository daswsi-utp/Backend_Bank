package com.bank.service_payment.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class PaymentResponseDTO {
    private Long id;
    private Long accountId;
    private String company;
    private String referenceNumber;
    private BigDecimal amount;
    private LocalDateTime date;
}
