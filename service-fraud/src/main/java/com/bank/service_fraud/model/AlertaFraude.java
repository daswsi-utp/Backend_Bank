package com.bank.service_fraud.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "alertas_fraude")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlertaFraude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private Integer id;

    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @Column(name = "id_transaccion")
    private Integer idTransaccion;

    @ManyToOne
    @JoinColumn(name = "id_tipo_transaccion", nullable = false)
    private TipoTransaccionAlerta tipoTransaccion;

    @Column(name = "score_riesgo", precision = 5, scale = 2)
    private BigDecimal scoreRiesgo;

    @Column(columnDefinition = "TEXT")
    private String motivo;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fecha = LocalDateTime.now();

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean confirmada = false;
}