package com.bank.service_loan.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prestamos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamo")
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long userId;

    @Column(name = "monto_solicitado", nullable = false)
    private BigDecimal requestedAmount;

    @Column(name = "monto_aprobado")
    private BigDecimal approvedAmount;

    @Column(name = "tasa_interes", nullable = false)
    private BigDecimal interestRate;

    @Column(nullable = false)
    private Integer installments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado_prestamo")
    private LoanStatus status;

    @Column(name = "fecha_solicitud", insertable = false, updatable = false)
    private LocalDateTime requestDate;
}
