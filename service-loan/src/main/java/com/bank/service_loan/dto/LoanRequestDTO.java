package com.bank.service_loan.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanRequestDTO {

    @NotNull
    private Long userId;

    @NotNull
    @DecimalMin(value = "0.01", message = "Requested amount must be greater than 0")
    private BigDecimal requestedAmount;

    @NotNull
    @DecimalMin(value = "0.01", message = "Interest rate must be greater than 0")
    private BigDecimal interestRate;

    @NotNull
    @Min(value = 1, message = "Installments must be at least 1")
    private Integer installments;
}
