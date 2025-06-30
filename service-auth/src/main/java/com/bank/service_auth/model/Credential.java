package com.bank.service_auth.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "credenciales", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_usuario", "tipo_usuario"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credencial")
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private UserType userType;

    @Column(name = "hash_contrasena", nullable = false)
    private String passwordHash;

    @Column(name = "rol", nullable = false)
    private String role = "CLIENTE";

    @Column(name = "esta_activo")
    private Boolean isActive = true;

    @Column(name = "intentos_fallidos")
    private Integer failedAttempts = 0;

    @Column(name = "cuenta_bloqueada")
    private Boolean accountLocked = false;

    @Column(name = "dos_factores_activado")
    private Boolean twoFactorEnabled = false;

    @Column(name = "ultimo_login")
    private LocalDateTime lastLogin;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime lastUpdate;
}
