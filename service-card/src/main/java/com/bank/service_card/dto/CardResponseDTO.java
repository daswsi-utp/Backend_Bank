package com.bank.service_card.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CardResponseDTO {

    private Long id;
    private Long userId;
    private String cardNumber;
    private String cardTypeName;
    private String cardStatusName;
    private String cvv;
    private LocalDate expirationDate;
}
