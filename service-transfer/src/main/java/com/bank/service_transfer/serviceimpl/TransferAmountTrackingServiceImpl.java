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
    public BigDecimal getDailyTransferAmount(String accountId, LocalDateTime date) {
        LocalDateTime startOfDay = date.toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1);

        return transactionRepository.findBySourceAccountIdAndDateBetween(accountId, startOfDay, endOfDay)
            .stream()
            .map(Transaction::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
