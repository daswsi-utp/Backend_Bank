package com.bank.serviceuser.controller;

import lombok.Data;

@Data
public class UsuarioRequest {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String telefono;
    private String dni;
    private String departamento;
    private String provincia;
    private String distrito;
    private String direccion;
    private String password;
}
