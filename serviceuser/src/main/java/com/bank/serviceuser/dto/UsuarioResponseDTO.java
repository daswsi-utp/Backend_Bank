package com.bank.serviceuser.dto;

import lombok.Data;

@Data
public class UsuarioResponseDTO {

    private Long id;

    private String tipo;

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

    private String fechaCreacion;
}
