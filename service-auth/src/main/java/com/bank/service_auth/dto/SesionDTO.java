package com.bank.service_auth.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SesionDTO {
    private String ip;
    private String userAgent;
    private LocalDateTime inicio;
    private LocalDateTime cierre;
    private Boolean estaActiva;
}
