package com.bank.service_auth.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private Long id;
    private String email;
    private String nombre;
    private String dni;
}
