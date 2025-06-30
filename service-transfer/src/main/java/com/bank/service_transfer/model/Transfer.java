package com.bank.service_transfer.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transferencias", indexes = {
        @Index(name = "idx_cuenta_origen", columnList = "cuenta_origen"),
        @Index(name = "idx_cuenta_destino", columnList = "cuenta_destino"),
        @Index(name = "idx_fechas", columnList = "fecha_solicitud, fecha_completada")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transferencia")
    private Long id;

    @Column(name = "cuenta_origen", nullable = false)
    private Long sourceAccount;

    @Column(name = "cuenta_destino", nullable = false)
    private Long destinationAccount;

    @Column(nullable = false)
    private BigDecimal monto;

    @Column(length = 3)
    private String moneda;

    private String concepto;
    private String referencia;

    @Column(name = "id_estado")
    private Byte estadoId;

    @Column(name = "fecha_solicitud", updatable = false)
    private LocalDateTime fechaSolicitud;

    @Column(name = "fecha_completada")
    private LocalDateTime fechaCompletada;

    @PrePersist
    protected void onCreate() {
        this.fechaSolicitud = LocalDateTime.now();
    }
}
