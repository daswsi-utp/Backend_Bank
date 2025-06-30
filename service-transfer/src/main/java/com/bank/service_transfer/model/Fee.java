package com.bank.service_transfer.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "comisiones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comision")
    private Long id;

    @Column(name = "id_transferencia", nullable = false)
    private Long transferId;

    @Column(nullable = false)
    private BigDecimal monto;

    @Column(name = "tipo_comision", nullable = false)
    private String tipo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;
}
