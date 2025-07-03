package com.bank.service_auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponseDTO {
    private Long userId;
    private String email;
    private String role;
    private String userType;
}
