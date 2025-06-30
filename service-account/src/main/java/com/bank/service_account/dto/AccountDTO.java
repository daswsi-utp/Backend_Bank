package com.bank.service_account.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDTO {
    private Long id;
    private Long userId;
    private String accountNumber;
    private Byte accountTypeId;
    private BigDecimal balance;
    private BigDecimal availableBalance;
    private Byte accountStatusId;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdate;
}
