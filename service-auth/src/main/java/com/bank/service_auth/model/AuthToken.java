package com.bank.service_auth.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "auth_tokens")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_token")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private AuthUsuario usuario;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String token;

    @Column(name = "refresh_token", columnDefinition = "TEXT")
    private String refreshToken;

    @Column(name = "fecha_emision")
    private LocalDateTime fechaEmision;

    private LocalDateTime expiracion;

    @Column(name = "esta_revocado")
    private Boolean estaRevocado;
}
