package com.bank.service_transfer.service;

import com.bank.service_transfer.model.TransferLimit;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing transfer limits
 */
public interface TransferLimitService {
    // Core limit operations
    TransferLimit createTransferLimit(TransferLimit transferLimit);
    Optional<TransferLimit> getTransferLimitByAccountId(String accountId);
    
    // Limit management
    TransferLimit updateTransferLimit(String accountId, BigDecimal newLimit);
    void deleteTransferLimit(String accountId);
    
    // Validation operations
    boolean isTransferAllowed(String accountId, BigDecimal amount);
    BigDecimal getRemainingDailyLimit(String accountId);
    
    // Query operations
    List<TransferLimit> getLimitsByAmountRange(BigDecimal minAmount, BigDecimal maxAmount);
    List<TransferLimit> getAccountsExceedingLimit(BigDecimal amount);
}
