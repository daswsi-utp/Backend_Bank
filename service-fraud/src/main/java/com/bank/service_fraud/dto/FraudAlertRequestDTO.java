package com.bank.service_fraud.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FraudAlertRequestDTO {

    @NotNull
    private Long userId;

    @NotNull
    private Integer transactionTypeId;

    @NotNull
    private Long transactionId;

    @DecimalMin("0.00")
    @DecimalMax("100.00")
    private BigDecimal riskScore;

    @NotBlank
    private String reason;
}
