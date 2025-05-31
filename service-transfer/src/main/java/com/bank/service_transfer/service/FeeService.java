package com.bank.service_transfer.service;

import com.bank.service_transfer.model.Fee;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing transfer fees
 */
public interface FeeService {
    // Core fee operations
    Fee calculateTransferFee(Long transactionId, BigDecimal transferAmount);
    Fee createFee(Fee fee);
    Optional<Fee> getFeeById(Long id);
    
    // Transaction related operations
    List<Fee> getFeesByTransactionId(Long transactionId);
    BigDecimal getTotalFeesByTransactionId(Long transactionId);
    
    // Fee calculation methods
    BigDecimal calculateFeeAmount(BigDecimal transferAmount);
    boolean isFeeApplicable(BigDecimal transferAmount);
    
    // Reporting operations
    List<Fee> getFeesByAmountRange(BigDecimal minAmount, BigDecimal maxAmount);
    BigDecimal getTotalFeesCollected();
}
