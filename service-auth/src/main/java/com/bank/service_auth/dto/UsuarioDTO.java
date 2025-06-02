package com.bank.service_auth.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
    private String nombre;
    private String apePaterno;
    private String apeMaterno;
    private String email;
    private String telefono;
    private String dni;
    private String departamento;
    private String provincia;
    private String distrito;
    private String direccion;
}
