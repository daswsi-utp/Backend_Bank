package com.bank.service_loan.service;

import com.bank.service_loan.dto.LoanRequestDTO;
import com.bank.service_loan.dto.LoanResponseDTO;

import java.util.List;
import java.util.Optional;

public interface LoanService {
    LoanResponseDTO createLoan(LoanRequestDTO dto);
    Optional<LoanResponseDTO> getLoanById(Long id);
    List<LoanResponseDTO> getLoansByUserId(Long userId);
    List<LoanResponseDTO> getAllLoans();
    LoanResponseDTO approveLoan(Long id, double approvedAmount);
}
