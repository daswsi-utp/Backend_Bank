package com.bank.service_loan.repository;

import com.bank.service_loan.model.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanStatusRepository extends JpaRepository<LoanStatus, Byte> {
}
