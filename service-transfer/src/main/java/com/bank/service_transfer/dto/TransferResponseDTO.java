package com.bank.service_transfer.dto;

import lombok.Data;
import lombok.Builder;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.bank.service_transfer.model.Transaction.TransactionStatus;

/**
 * DTO for transfer response data
 */
@Data
@Builder
public class TransferResponseDTO {
    private Long transactionId;
    private String sourceAccountId;
    private String destinationAccountId;
    private BigDecimal amount;
    private LocalDateTime date;
    private TransactionStatus status;
    private String reference;
    private BigDecimal fee;
}
