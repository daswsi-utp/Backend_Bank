package com.bank.service_loan.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanRequestDTO {

    private Long userId;
    private BigDecimal requestedAmount;
    private BigDecimal approvedAmount;
    private Byte loanTypeId;
    private BigDecimal interestRate;
    private Integer installments;
    private Byte loanStatusId;
    private LocalDate dueDate;
}
