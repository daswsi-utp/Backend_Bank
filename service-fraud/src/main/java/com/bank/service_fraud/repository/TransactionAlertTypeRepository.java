package com.bank.service_fraud.repository;

import com.bank.service_fraud.model.TransactionAlertType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionAlertTypeRepository extends JpaRepository<TransactionAlertType, Integer> {
}
