package com.bank.service_fraud.repository;

import com.bank.service_fraud.model.FraudPattern;
import com.bank.service_fraud.model.Severity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FraudPatternRepository extends JpaRepository<FraudPattern, Integer> {

    // Buscar solo los patrones activos
    List<FraudPattern> findByIsActiveTrue();

    // Buscar patrones por nivel de severidad
    List<FraudPattern> findBySeverity(Severity severity);
}
