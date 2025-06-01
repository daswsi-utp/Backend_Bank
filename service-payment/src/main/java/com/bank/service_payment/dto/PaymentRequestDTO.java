package com.bank.service_payment.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequestDTO {

    @NotNull(message = "Account ID is required")
    private Long accountId;

    @NotBlank(message = "Company name is required")
    private String company;

    @NotBlank(message = "Reference number is required")
    private String referenceNumber;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    private BigDecimal amount;
}
