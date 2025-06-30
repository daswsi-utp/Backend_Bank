package com.bank.service_auth.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AuthTokenDTO {
    private Long id;
    private Long userId;
    private String userType;
    private String token;
    private String refreshToken;
    private LocalDateTime issuedAt;
    private LocalDateTime expiration;
    private boolean isRevoked;
}
