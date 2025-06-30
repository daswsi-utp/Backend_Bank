package com.bank.service_card.dto;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardTransactionDTO {
    private Long id;
    private Long cardId;
    private BigDecimal amount;
    private String currency;
    private String merchant;
    private String location;
    private String authorizationCode;
    private Timestamp date;
}
