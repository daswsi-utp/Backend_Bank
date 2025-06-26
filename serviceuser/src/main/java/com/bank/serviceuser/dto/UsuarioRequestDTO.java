package com.bank.serviceuser.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioRequestDTO {

    @NotBlank
    private String tipo; // "CLIENTE" o "EMPLEADO"

    @NotBlank
    private String nombre;

    @NotBlank
    private String apePaterno;

    private String apeMaterno;

    @Email
    @NotBlank
    private String email;

    private String telefono;

    @NotBlank
    private String dni;

    private String departamento;

    private String provincia;

    private String distrito;

    private String direccion;
}
