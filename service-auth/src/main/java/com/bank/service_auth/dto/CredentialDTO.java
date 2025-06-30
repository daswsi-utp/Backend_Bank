package com.bank.service_auth.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CredentialDTO {
    private Long id;
    private Long userId;
    private String userType;
    private String role;
    private boolean isActive;
    private boolean accountLocked;
    private boolean twoFactorEnabled;
    private LocalDateTime lastLogin;
}
