package com.bank.service_card.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "transacciones_tarjeta", indexes = {
        @Index(name = "idx_tarjeta_fecha", columnList = "id_tarjeta, fecha")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Long id;

    @Column(name = "id_tarjeta", nullable = false)
    private Long cardId;

    @Column(name = "monto", nullable = false)
    private BigDecimal amount;

    @Column(name = "moneda", length = 3)
    private String currency = "PEN";

    @Column(name = "comercio", nullable = false, length = 255)
    private String merchant;

    @Column(name = "ubicacion", length = 255)
    private String location;

    @Column(name = "codigo_autorizacion", length = 20)
    private String authorizationCode;

    @Column(name = "fecha")
    private Timestamp date;
}
