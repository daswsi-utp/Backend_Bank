package com.bank.service_loan.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class LoanPaymentDTO {
    private Long id;
    private Long loanId;
    private BigDecimal amountPaid;
    private LocalDateTime paymentDate;
}
