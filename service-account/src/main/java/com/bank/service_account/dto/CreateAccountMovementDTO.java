package com.bank.service_account.dto;

import com.bank.service_account.model.MovementType;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAccountMovementDTO {
    private Long accountId;
    private MovementType movementType;
    private BigDecimal amount;
    private String description;
    private String reference;
}
