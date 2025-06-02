package com.bank.service_employee.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
