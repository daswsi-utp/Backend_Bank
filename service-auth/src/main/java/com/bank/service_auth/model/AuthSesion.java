package com.bank.service_auth.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "auth_sesiones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthSesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sesion")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private AuthUsuario usuario;

    private String ip;

    @Column(name = "user_agent")
    private String userAgent;

    private LocalDateTime inicio;
    private LocalDateTime cierre;

    @Column(name = "esta_activa")
    private Boolean estaActiva;
}
