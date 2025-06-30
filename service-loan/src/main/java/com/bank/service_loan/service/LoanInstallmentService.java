package com.bank.service_loan.service;

import com.bank.service_loan.dto.LoanInstallmentRequestDTO;
import com.bank.service_loan.dto.LoanInstallmentResponseDTO;

import java.util.List;

public interface LoanInstallmentService {

    LoanInstallmentResponseDTO createInstallment(LoanInstallmentRequestDTO request);

    LoanInstallmentResponseDTO getInstallmentById(Long id);

    List<LoanInstallmentResponseDTO> getInstallmentsByLoanId(Long loanId);

    LoanInstallmentResponseDTO updateInstallment(Long id, LoanInstallmentRequestDTO request);

    void deleteInstallment(Long id);
}
