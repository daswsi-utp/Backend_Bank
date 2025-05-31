package com.bank.service_transfer.repository;

import com.bank.service_transfer.model.TransferLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Repository interface for TransferLimit entity operations
 */
@Repository
public interface TransferLimitRepository extends JpaRepository<TransferLimit, String> {
    // Find limits greater than specific amount
    List<TransferLimit> findByDailyLimitGreaterThan(BigDecimal amount);
    
    // Find limits less than specific amount
    List<TransferLimit> findByDailyLimitLessThan(BigDecimal amount);
    
    // Find limits between range
    List<TransferLimit> findByDailyLimitBetween(BigDecimal minAmount, BigDecimal maxAmount);
}
