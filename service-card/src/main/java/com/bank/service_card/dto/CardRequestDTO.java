package com.bank.service_card.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CardRequestDTO {

    @NotNull
    private Long userId;

    @NotBlank
    @Size(min = 16, max = 16)
    private String cardNumber;

    @NotBlank
    @Size(min = 3, max = 4)
    private String cvv;

    @NotNull
    private Byte cardTypeId;

    @NotNull
    private LocalDate expirationDate;

    @NotNull
    private Byte cardStatusId;
}
