package com.bank.service_transfer.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Service interface for tracking transfer amounts
 */
public interface TransferAmountTrackingService {
    BigDecimal getDailyTransferAmount(String accountId, LocalDateTime date);
}
