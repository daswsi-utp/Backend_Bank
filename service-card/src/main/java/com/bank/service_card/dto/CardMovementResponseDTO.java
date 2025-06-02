package com.bank.service_card.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class CardMovementResponseDTO {

    private Long id;
    private Long cardId;
    private BigDecimal amount;
    private String merchant;
    private String location;
    private LocalDateTime date;
}
