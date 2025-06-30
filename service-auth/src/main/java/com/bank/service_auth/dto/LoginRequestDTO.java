package com.bank.service_auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
    private Long userId;
    private String password;
    private String userType; // "CLIENTE" o "EMPLEADO"
}
