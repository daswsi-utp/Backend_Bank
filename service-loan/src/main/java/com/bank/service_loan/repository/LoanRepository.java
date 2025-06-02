package com.bank.service_loan.repository;


import com.bank.service_loan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoanRepository extends JpaRepository<Loan, Long> {

}
