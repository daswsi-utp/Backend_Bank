package com.bank.service_log.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LogRequestDTO {

    @NotNull
    private Long userId;

    @NotBlank
    private String ip;

    @NotBlank
    private String navegador;

    @NotBlank
    private String activityType;
}
