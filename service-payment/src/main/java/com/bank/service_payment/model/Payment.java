package com.bank.service_payment.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos", indexes = {
        @Index(name = "idx_usuario_pago", columnList = "id_usuario"),
        @Index(name = "idx_referencia", columnList = "numero_referencia")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_servicio", nullable = false)
    private ServiceEntity service;

    @Column(name = "id_cuenta", nullable = false)
    private Long accountId;

    @Column(name = "monto", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "comision", precision = 15, scale = 2)
    private BigDecimal fee = BigDecimal.ZERO;

    @Column(name = "numero_referencia", nullable = false, length = 50)
    private String referenceNumber;

    @Column(name = "codigo_barras", length = 100)
    private String barcode;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime date = LocalDateTime.now();
}
