package com.bank.service_card.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardTransactionRequestDTO {
    private Long cardId;
    private BigDecimal amount;
    private String currency;
    private String merchant;
    private String location;
    private String authorizationCode;
}
