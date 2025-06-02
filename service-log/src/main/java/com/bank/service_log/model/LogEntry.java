package com.bank.service_log.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "logs_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_log")
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String ip;

    @Column(nullable = false)
    private String navegador;

    @Column(name = "tipo_actividad", nullable = false)
    private String activityType;

    @Column(nullable = false, insertable = false, updatable = false)
    private LocalDateTime fecha;
}
