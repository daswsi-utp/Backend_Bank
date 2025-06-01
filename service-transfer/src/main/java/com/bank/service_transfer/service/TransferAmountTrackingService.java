package com.bank.service_transfer.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface TransferAmountTrackingService {
    BigDecimal getDailyTransferAmount(Long accountId, LocalDateTime date);
}
