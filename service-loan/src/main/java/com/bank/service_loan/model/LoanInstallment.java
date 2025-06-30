package com.bank.service_loan.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "cuotas_prestamo", uniqueConstraints = {
        @UniqueConstraint(name = "uk_prestamo_cuota", columnNames = {"id_prestamo", "numero_cuota"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanInstallment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuota")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prestamo", nullable = false)
    private Loan loan;

    @Column(name = "numero_cuota", nullable = false)
    private Integer installmentNumber;

    @Column(name = "monto_cuota", nullable = false)
    private BigDecimal amount;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate dueDate;

    @Column(name = "id_estado_cuota")
    private Byte installmentStatusId;

    @Column(name = "fecha_pago")
    private LocalDateTime paymentDate;
}
