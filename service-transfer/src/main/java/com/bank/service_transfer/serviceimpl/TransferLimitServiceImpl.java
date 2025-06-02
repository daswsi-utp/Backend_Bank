package com.bank.service_transfer.serviceimpl;

import com.bank.service_transfer.model.TransferLimit;
import com.bank.service_transfer.repository.TransferLimitRepository;
import com.bank.service_transfer.service.TransferLimitService;
import com.bank.service_transfer.service.TransferAmountTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransferLimitServiceImpl implements TransferLimitService {

    private final TransferLimitRepository transferLimitRepository;
    private final TransferAmountTrackingService transferAmountTrackingService;

    @Override
    @Transactional
    public TransferLimit createTransferLimit(TransferLimit transferLimit) {
        return transferLimitRepository.save(transferLimit);
    }

    @Override
    public Optional<TransferLimit> getTransferLimitByAccountId(String accountId) {
        return transferLimitRepository.findById(accountId);
    }

    @Override
    @Transactional
    public TransferLimit updateTransferLimit(String accountId, BigDecimal newLimit) {
        TransferLimit limit = transferLimitRepository.findById(accountId)
            .orElseThrow(() -> new IllegalArgumentException("Transfer limit not found for account: " + accountId));
        
        limit.setDailyLimit(newLimit);
        return transferLimitRepository.save(limit);
    }

    @Override
    @Transactional
    public void deleteTransferLimit(String accountId) {
        if (!transferLimitRepository.existsById(accountId)) {
            throw new IllegalArgumentException("Transfer limit not found for account: " + accountId);
        }
        transferLimitRepository.deleteById(accountId);
    }

    @Override
    public boolean isTransferAllowed(String accountId, BigDecimal amount) {
        Optional<TransferLimit> limitOpt = getTransferLimitByAccountId(accountId);
        if (limitOpt.isEmpty()) {
            return false;
        }

        BigDecimal remainingLimit = getRemainingDailyLimit(accountId);
        return remainingLimit.compareTo(amount) >= 0;
    }

    @Override
    public BigDecimal getRemainingDailyLimit(String accountId) {
        TransferLimit limit = getTransferLimitByAccountId(accountId)
            .orElseThrow(() -> new IllegalArgumentException("Transfer limit not found for account: " + accountId));

        BigDecimal dailyTransfers = transferAmountTrackingService.getDailyTransferAmount(accountId, LocalDateTime.now());
        return limit.getDailyLimit().subtract(dailyTransfers);
    }

    @Override
    public List<TransferLimit> getLimitsByAmountRange(BigDecimal minAmount, BigDecimal maxAmount) {
        return transferLimitRepository.findByDailyLimitBetween(minAmount, maxAmount);
    }

    @Override
    public List<TransferLimit> getAccountsExceedingLimit(BigDecimal amount) {
        return transferLimitRepository.findByDailyLimitGreaterThan(amount);
    }
}
