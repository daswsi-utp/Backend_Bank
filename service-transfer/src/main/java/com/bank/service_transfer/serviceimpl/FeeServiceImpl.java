package com.bank.service_transfer.serviceimpl;

import com.bank.service_transfer.model.Fee;
import com.bank.service_transfer.repository.FeeRepository;
import com.bank.service_transfer.service.FeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeeServiceImpl implements FeeService {

    private final FeeRepository feeRepository;
    
    // Constants for fee calculation
    private static final BigDecimal FEE_PERCENTAGE = new BigDecimal("0.005"); // 0.5%
    private static final BigDecimal MINIMUM_FEE_AMOUNT = new BigDecimal("100.00");

    @Override
    @Transactional
    public Fee calculateTransferFee(Long transactionId, BigDecimal transferAmount) {
        if (!isFeeApplicable(transferAmount)) {
            return null;
        }

        Fee fee = new Fee();
        fee.setAmount(calculateFeeAmount(transferAmount));
        return createFee(fee);
    }

    @Override
    @Transactional
    public Fee createFee(Fee fee) {
        return feeRepository.save(fee);
    }

    @Override
    public Optional<Fee> getFeeById(Long id) {
        return feeRepository.findById(id);
    }

    @Override
    public List<Fee> getFeesByTransactionId(Long transactionId) {
        return feeRepository.findByTransactionId(transactionId);
    }

    @Override
    public BigDecimal getTotalFeesByTransactionId(Long transactionId) {
        return getFeesByTransactionId(transactionId)
            .stream()
            .map(Fee::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal calculateFeeAmount(BigDecimal transferAmount) {
        return transferAmount
            .multiply(FEE_PERCENTAGE)
            .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean isFeeApplicable(BigDecimal transferAmount) {
        return transferAmount.compareTo(MINIMUM_FEE_AMOUNT) >= 0;
    }

    @Override
    public List<Fee> getFeesByAmountRange(BigDecimal minAmount, BigDecimal maxAmount) {
        List<Fee> fees = feeRepository.findByAmountGreaterThan(minAmount);
        return fees.stream()
            .filter(fee -> fee.getAmount().compareTo(maxAmount) <= 0)
            .toList();
    }

    @Override
    public BigDecimal getTotalFeesCollected() {
        return feeRepository.findAll()
            .stream()
            .map(Fee::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
