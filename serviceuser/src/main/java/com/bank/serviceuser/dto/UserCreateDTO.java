package com.bank.serviceuser.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class UserCreateDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apePaterno;

    @NotBlank
    private String apeMaterno;

    @Email
    @NotBlank
    private String email;

    @Pattern(regexp = "^\\d{9,15}$", message = "Número de teléfono inválido")
    private String telefono;

    @NotBlank
    private String dni;

    private String departamento;
    private String provincia;
    private String distrito;
    private String direccion;

    @NotBlank
    private String password; // ← nuevo campo para credencial
}
