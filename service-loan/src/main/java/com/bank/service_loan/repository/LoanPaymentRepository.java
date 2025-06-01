package com.bank.service_loan.repository;

import com.bank.service_loan.model.LoanPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanPaymentRepository extends JpaRepository<LoanPayment, Long> {
    List<LoanPayment> findByLoanId(Long loanId);
}
