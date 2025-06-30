package com.bank.service_loan.repository;

import com.bank.service_loan.model.LoanInstallment;
import com.bank.service_loan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanInstallmentRepository extends JpaRepository<LoanInstallment, Long> {

    List<LoanInstallment> findByLoan(Loan loan);

    List<LoanInstallment> findByLoanId(Long loanId);
}
