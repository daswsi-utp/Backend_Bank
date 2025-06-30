package com.bank.service_loan.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanInstallmentRequestDTO {

    private Long loanId;
    private Integer installmentNumber;
    private BigDecimal amount;
    private LocalDate dueDate;
    private Byte installmentStatusId;
    private LocalDateTime paymentDate;
}
