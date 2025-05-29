package com.bank.service_transfer.repository;

import com.bank.service_transfer.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository interface for Fee entity operations
 */
@Repository
public interface FeeRepository extends JpaRepository<Fee, Long> {
    // Find fees by transaction id
    List<Fee> findByTransactionId(Long transactionId);
    
    // Find fees greater than a specific amount
    List<Fee> findByAmountGreaterThan(BigDecimal amount);
    
    // Find fees by transaction id and amount greater than
    List<Fee> findByTransactionIdAndAmountGreaterThan(Long transactionId, BigDecimal amount);
}
