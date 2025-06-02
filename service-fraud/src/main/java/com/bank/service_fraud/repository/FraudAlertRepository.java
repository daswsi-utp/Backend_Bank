package com.bank.service_fraud.repository;

import com.bank.service_fraud.model.FraudAlert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FraudAlertRepository extends JpaRepository<FraudAlert, Integer> {
    List<FraudAlert> findByUserId(Long userId);
    List<FraudAlert> findByConfirmed(Boolean confirmed);
}
