package com.bank.service_loan.service;

import com.bank.service_loan.dto.LoanRequestDTO;
import com.bank.service_loan.dto.LoanResponseDTO;

import java.util.List;

public interface LoanService {

    LoanResponseDTO createLoan(LoanRequestDTO request);

    LoanResponseDTO getLoanById(Long id);

    List<LoanResponseDTO> getAllLoans();

    List<LoanResponseDTO> getLoansByUserId(Long userId);

    LoanResponseDTO updateLoan(Long id, LoanRequestDTO request);

    void deleteLoan(Long id);
}
