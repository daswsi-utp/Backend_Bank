package com.bank.service_transfer.service;

import com.bank.service_transfer.model.Fee;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface FeeService {

    Fee calculateTransferFee(Long transactionId, BigDecimal transferAmount);
    Fee createFee(Fee fee);
    Optional<Fee> getFeeById(Long id);

    List<Fee> getFeesByTransactionId(Long transactionId);
    BigDecimal getTotalFeesByTransactionId(Long transactionId);

    BigDecimal calculateFeeAmount(BigDecimal transferAmount);
    boolean isFeeApplicable(BigDecimal transferAmount);

    List<Fee> getFeesByAmountRange(BigDecimal minAmount, BigDecimal maxAmount);
    BigDecimal getTotalFeesCollected();
}
