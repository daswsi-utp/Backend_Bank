package com.bank.service_auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponseDTO {
    private String token;
    private String refreshToken;
    private String role;
    private boolean twoFactorEnabled;
}
