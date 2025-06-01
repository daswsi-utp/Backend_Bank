package com.bank.service_transfer.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class TransferResponseDTO {
    private Long transactionId;
    private Long sourceAccountId;
    private Long destinationAccountId;
    private BigDecimal amount;
    private LocalDateTime date;
    private String statusName;
    private String reference;
    private BigDecimal fee;
}
