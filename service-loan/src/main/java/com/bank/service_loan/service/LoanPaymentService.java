package com.bank.service_loan.service;

import com.bank.service_loan.dto.LoanPaymentDTO;

import java.math.BigDecimal;
import java.util.List;

public interface LoanPaymentService {
    LoanPaymentDTO registerPayment(Long loanId, BigDecimal amount);
    List<LoanPaymentDTO> getPaymentsByLoanId(Long loanId);
}
