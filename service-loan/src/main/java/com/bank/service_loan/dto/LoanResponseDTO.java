package com.bank.service_loan.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanResponseDTO {

    private Long id;
    private Long userId;
    private BigDecimal requestedAmount;
    private BigDecimal approvedAmount;
    private Byte loanTypeId;
    private BigDecimal interestRate;
    private Integer installments;
    private Byte loanStatusId;
    private LocalDateTime requestDate;
    private LocalDateTime approvalDate;
    private LocalDate dueDate;

    private List<LoanInstallmentResponseDTO> installmentsList;
}
