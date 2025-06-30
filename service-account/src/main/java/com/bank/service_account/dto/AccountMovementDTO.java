package com.bank.service_account.dto;

import com.bank.service_account.model.MovementType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountMovementDTO {
    private Long id;
    private Long accountId;
    private MovementType movementType;
    private BigDecimal amount;
    private BigDecimal resultingBalance;
    private String description;
    private String reference;
    private LocalDateTime date;
}
