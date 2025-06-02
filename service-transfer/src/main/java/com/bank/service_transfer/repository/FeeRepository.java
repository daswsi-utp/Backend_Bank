package com.bank.service_transfer.repository;

import com.bank.service_transfer.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Long> {

    // Cargos asociados a una transacción
    List<Fee> findByTransactionId(Long transactionId);

    // Cargos mayores a cierto valor
    List<Fee> findByAmountGreaterThan(BigDecimal amount);

    // Cargos filtrados por transacción y mínimo
    List<Fee> findByTransactionIdAndAmountGreaterThan(Long transactionId, BigDecimal amount);
}
