package com.bank.service_fraud.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class FraudAlertResponseDTO {
    private Integer id;
    private Long userId;
    private String transactionTypeName;
    private Long transactionId;
    private BigDecimal riskScore;
    private String reason;
    private LocalDateTime fecha;
    private Boolean confirmed;
}
