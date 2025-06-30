package com.bank.service_account.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAccountDTO {
    private Long userId;
    private String accountNumber;
    private Byte accountTypeId;
    private BigDecimal balance;
    private BigDecimal availableBalance;
    private Byte accountStatusId;
}
