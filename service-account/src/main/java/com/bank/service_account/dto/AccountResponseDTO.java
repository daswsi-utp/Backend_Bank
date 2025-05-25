package com.bank.service_account.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDTO {

    private Long id;
    private String accountNumber;
    private Long userId;
    private String accountTypeName;
    private BigDecimal balance;
    private String accountStatusName;
    private LocalDateTime createdAt;
}
