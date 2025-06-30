package com.bank.service_loan.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "prestamos", indexes = {
        @Index(name = "idx_usuario_prestamo", columnList = "id_usuario")
})
@Getter
@Setter
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

    @Column(name = "id_tipo_prestamo", nullable = false)
    private Byte loanTypeId;

    @Column(name = "tasa_interes", nullable = false)
    private BigDecimal interestRate;

    @Column(name = "cuotas", nullable = false)
    private Integer installments;

    @Column(name = "id_estado_prestamo")
    private Byte loanStatusId;

    @Column(name = "fecha_solicitud")
    private LocalDateTime requestDate;

    @Column(name = "fecha_aprobacion")
    private LocalDateTime approvalDate;

    @Column(name = "fecha_vencimiento")
    private LocalDate dueDate;

    @OneToMany(mappedBy = "loan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoanInstallment> installmentsList;
}
