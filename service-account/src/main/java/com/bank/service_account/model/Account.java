package com.bank.service_account.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "cuentas", indexes = {
        @Index(name = "idx_usuario_cuenta", columnList = "id_usuario"),
        @Index(name = "idx_numero_cuenta", columnList = "numero_cuenta")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long userId;

    @Column(name = "numero_cuenta", nullable = false, unique = true, length = 20)
    private String accountNumber;

    @Column(name = "id_tipo_cuenta", nullable = false)
    private Byte accountTypeId;

    @Column(name = "saldo", precision = 15, scale = 2)
    private BigDecimal balance;

    @Column(name = "saldo_disponible", precision = 15, scale = 2)
    private BigDecimal availableBalance;

    @Column(name = "id_estado_cuenta")
    private Byte accountStatusId;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime creationDate;

    @Column(name = "fecha_ultima_actualizacion")
    private LocalDateTime lastUpdate;
}
