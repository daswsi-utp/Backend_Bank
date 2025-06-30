package com.bank.service_auth.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "auth_sesiones", indexes = {
        @Index(name = "idx_sesion_activa", columnList = "id_usuario, esta_activa")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sesion")
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false)
    private UserType userType;

    @Column(name = "ip")
    private String ip;

    @Column(name = "user_agent", columnDefinition = "TEXT")
    private String userAgent;

    @Column(name = "dispositivo")
    private String device;

    @Column(name = "inicio")
    private LocalDateTime start;

    @Column(name = "cierre")
    private LocalDateTime end;

    @Column(name = "esta_activa")
    private Boolean isActive = true;
}
