package com.bank.service_card.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardRequestDTO {
    private Long userId;
    private Long associatedAccountId;
    private String cardNumber;
    private Byte cardTypeId;
    private String cardHolderName;
    private LocalDate expirationDate;
    private Byte cardStatusId;
    private LocalDate issueDate;
    private LocalDate activationDate;
}
