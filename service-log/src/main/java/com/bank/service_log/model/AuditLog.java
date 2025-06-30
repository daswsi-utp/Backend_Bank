package com.bank.service_log.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs_auditoria", indexes = {
        @Index(name = "idx_usuario_log", columnList = "id_usuario"),
        @Index(name = "idx_fecha_accion", columnList = "fecha, accion")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log")
    private Long id;

    @Column(name = "id_usuario")
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private UserType userType;

    @Column(name = "accion", nullable = false)
    private String action;

    @Column(name = "entidad_afectada", nullable = false)
    private String affectedEntity;

    @Column(name = "id_entidad_afectada")
    private Long affectedEntityId;

    @Column(name = "ip")
    private String ip;

    @Column(name = "user_agent", columnDefinition = "TEXT")
    private String userAgent;

    @Column(name = "detalles", columnDefinition = "TEXT")
    private String details;

    @Column(name = "fecha")
    private LocalDateTime date;
}
