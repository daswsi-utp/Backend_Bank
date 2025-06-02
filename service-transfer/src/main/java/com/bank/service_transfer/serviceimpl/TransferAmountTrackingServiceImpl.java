package com.bank.service_transfer.serviceimpl;

import com.bank.service_transfer.model.Transaction;
import com.bank.service_transfer.repository.TransactionRepository;
import com.bank.service_transfer.service.TransferAmountTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransferAmountTrackingServiceImpl implements TransferAmountTrackingService {

    private final TransactionRepository transactionRepository;

    @Override
    public BigDecimal getDailyTransferAmount(Long accountId, LocalDateTime date) {
        LocalDateTime start = date.toLocalDate().atStartOfDay();
        LocalDateTime end = start.plusDays(1);

        return transactionRepository.findBySourceAccountIdAndDateBetween(accountId, start, end).stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
