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
@Builder
public class FraudAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta")
    private Integer id;

    @Column(name = "id_usuario", nullable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_transaccion", nullable = false)
    private TransactionAlertType transactionType;

    @Column(name = "id_transaccion", nullable = false)
    private Long transactionId;

    @Column(name = "score_riesgo", nullable = false)
    private BigDecimal riskScore;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String reason;

    @Column(insertable = false, updatable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private Boolean confirmed;
}
