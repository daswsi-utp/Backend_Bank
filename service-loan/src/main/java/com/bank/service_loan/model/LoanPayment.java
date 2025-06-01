package com.bank.service_loan.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos_prestamo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestamo", nullable = false)
    private Loan loan;

    @Column(name = "monto_pagado", nullable = false)
    private BigDecimal amountPaid;

    @Column(name = "fecha_pago", insertable = false, updatable = false)
    private LocalDateTime paymentDate;
}
