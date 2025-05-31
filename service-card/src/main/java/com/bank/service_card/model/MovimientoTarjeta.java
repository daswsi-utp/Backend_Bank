
package com.bank.service_card.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos_tarjeta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimientoTarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Long id;

    @Column(name = "id_tarjeta", nullable = false)
    private Long idTarjeta;

    @Column(nullable = false)
    private BigDecimal monto;

    private String comercio;
    private String ubicacion;

    @Column(nullable = false)
    private LocalDateTime fecha;
}