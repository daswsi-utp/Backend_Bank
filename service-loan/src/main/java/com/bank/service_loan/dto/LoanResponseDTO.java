package com.bank.service_loan.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class LoanResponseDTO {
    private Long id;
    private Long userId;
    private BigDecimal requestedAmount;
    private BigDecimal approvedAmount;
    private BigDecimal interestRate;
    private Integer installments;
    private String status;
    private LocalDateTime requestDate;
}
