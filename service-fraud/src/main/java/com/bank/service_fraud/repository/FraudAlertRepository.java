package com.bank.service_fraud.repository;

import com.bank.service_fraud.model.FraudAlert;
import com.bank.service_fraud.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraudAlertRepository extends JpaRepository<FraudAlert, Long> {

    // Buscar alertas por ID de usuario
    List<FraudAlert> findByUserId(Long userId);

    // Buscar alertas por tipo de transacción
    List<FraudAlert> findByTransactionType(TransactionType transactionType);

    // Buscar alertas por transacción específica
    List<FraudAlert> findByTransactionTypeAndTransactionId(TransactionType transactionType, Long transactionId);
}
