package com.bank.service_transfer.serviceimpl;

import com.bank.service_transfer.model.TransferLimit;
import com.bank.service_transfer.repository.TransferLimitRepository;
import com.bank.service_transfer.service.TransferAmountTrackingService;
import com.bank.service_transfer.service.TransferLimitService;
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
    private final TransferAmountTrackingService trackingService;

    @Override
    @Transactional
    public TransferLimit createTransferLimit(TransferLimit limit) {
        return transferLimitRepository.save(limit);
    }

    @Override
    public Optional<TransferLimit> getTransferLimitByAccountId(Long accountId) {
        return transferLimitRepository.findById(accountId);
    }

    @Override
    @Transactional
    public TransferLimit updateTransferLimit(Long accountId, BigDecimal newLimit) {
        TransferLimit limit = transferLimitRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Límite no encontrado para la cuenta " + accountId));
        limit.setDailyLimit(newLimit);
        return transferLimitRepository.save(limit);
    }

    @Override
    @Transactional
    public void deleteTransferLimit(Long accountId) {
        if (!transferLimitRepository.existsById(accountId)) {
            throw new RuntimeException("Límite no encontrado para la cuenta " + accountId);
        }
        transferLimitRepository.deleteById(accountId);
    }

    @Override
    public boolean isTransferAllowed(Long accountId, BigDecimal amount) {
        BigDecimal remaining = getRemainingDailyLimit(accountId);
        return remaining.compareTo(amount) >= 0;
    }

    @Override
    public BigDecimal getRemainingDailyLimit(Long accountId) {
        TransferLimit limit = transferLimitRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Límite no definido para la cuenta " + accountId));

        BigDecimal used = trackingService.getDailyTransferAmount(accountId, LocalDateTime.now());
        return limit.getDailyLimit().subtract(used);
    }

    @Override
    public List<TransferLimit> getLimitsByAmountRange(BigDecimal min, BigDecimal max) {
        return transferLimitRepository.findByDailyLimitBetween(min, max);
    }

    @Override
    public List<TransferLimit> getAccountsExceedingLimit(BigDecimal amount) {
        return transferLimitRepository.findByDailyLimitGreaterThan(amount);
    }
}
