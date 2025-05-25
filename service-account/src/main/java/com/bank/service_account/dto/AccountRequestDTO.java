package com.bank.service_account.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class AccountRequestDTO {

    @NotNull
    private Long userId;

    @NotBlank
    @Size(min = 10, max = 20)
    private String accountNumber;

    @NotNull
    private Byte accountTypeId;

    @DecimalMin(value = "0.00")
    private BigDecimal balance = BigDecimal.ZERO;

    @NotNull
    private Byte accountStatusId;
}
