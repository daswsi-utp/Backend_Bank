package com.bank.service_auth.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuthSessionDTO {
    private Long id;
    private Long userId;
    private String userType;
    private String ip;
    private String userAgent;
    private String device;
    private LocalDateTime start;
    private LocalDateTime end;
    private boolean isActive;
}
