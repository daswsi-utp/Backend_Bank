package com.bank.service_employee.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String dni;
    private String rol;
}
