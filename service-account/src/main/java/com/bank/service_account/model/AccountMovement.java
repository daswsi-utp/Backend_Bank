package com.bank.service_account.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos_cuenta", indexes = {
        @Index(name = "idx_cuenta_fecha", columnList = "id_cuenta, fecha")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Long id;

    @Column(name = "id_cuenta", nullable = false)
    private Long accountId;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimiento", nullable = false)
    private MovementType movementType;

    @Column(name = "monto", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "saldo_resultante", precision = 15, scale = 2)
    private BigDecimal resultingBalance;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "referencia", length = 100)
    private String reference;

    @Column(name = "fecha")
    private LocalDateTime date;
}
