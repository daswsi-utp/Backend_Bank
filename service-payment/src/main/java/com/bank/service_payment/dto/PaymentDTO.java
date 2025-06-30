package com.bank.service_payment.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {
    private Long id;
    private Long userId;
    private Integer serviceId;
    private Long accountId;
    private BigDecimal amount;
    private BigDecimal fee;
    private String referenceNumber;
    private String barcode;
    private LocalDateTime date;
}
