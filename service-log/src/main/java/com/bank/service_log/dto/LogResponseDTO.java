package com.bank.service_log.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LogResponseDTO {
    private Long id;
    private Long userId;
    private String ip;
    private String navegador;
    private String activityType;
    private LocalDateTime fecha;
}

