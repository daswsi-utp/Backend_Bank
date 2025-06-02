package com.bank.service_transfer.service;

import com.bank.service_transfer.model.TransferLimit;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface TransferLimitService {

    TransferLimit createTransferLimit(TransferLimit limit);
    Optional<TransferLimit> getTransferLimitByAccountId(Long accountId);
    TransferLimit updateTransferLimit(Long accountId, BigDecimal newLimit);
    void deleteTransferLimit(Long accountId);

    boolean isTransferAllowed(Long accountId, BigDecimal amount);
    BigDecimal getRemainingDailyLimit(Long accountId);

    List<TransferLimit> getLimitsByAmountRange(BigDecimal minAmount, BigDecimal maxAmount);
    List<TransferLimit> getAccountsExceedingLimit(BigDecimal amount);
}
