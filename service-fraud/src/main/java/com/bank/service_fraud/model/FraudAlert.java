package com.bank.service_fraud.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "alertas_fraude", indexes = {
        @Index(name = "idx_usuario_fraude", columnList = "id_usuario"),
        @Index(name = "idx_transaccion", columnList = "tipo_transaccion, id_transaccion")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_transaccion", nullable = false)
    private TransactionType transactionType;

    @Column(name = "id_transaccion", nullable = false)
    private Long transactionId;

    @Column(name = "score_riesgo", nullable = false)
    private Double riskScore;

    @Column(name = "motivo", columnDefinition = "TEXT", nullable = false)
    private String reason;

    @Column(name = "accion_tomada")
    private String actionTaken;

    @Column(name = "fecha")
    private Timestamp date;
}
