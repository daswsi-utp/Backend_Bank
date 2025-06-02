package com.bank.service_card.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardMovementRequestDTO {

    @NotNull
    private Long cardId;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal amount;

    private String merchant;
    private String location;
}
