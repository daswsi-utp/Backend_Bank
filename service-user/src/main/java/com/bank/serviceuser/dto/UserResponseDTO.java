package com.bank.serviceuser.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String nombreCompleto;
    private String email;
    private String telefono;
}
