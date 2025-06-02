package com.bank.service_auth.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "auth_usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthUsuario {

    @Id
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "hash_contrasena", nullable = false)
    private String hashContrasena;

    private String rol;

    @Column(name = "esta_activo")
    private Boolean estaActivo;

    @Column(name = "intentos_fallidos")
    private Integer intentosFallidos;

    @Column(name = "cuenta_bloqueada")
    private Boolean cuentaBloqueada;
}
