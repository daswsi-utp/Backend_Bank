package com.bank.service_card.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tarjetas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarjeta")
    private Long id;

    @Column(name = "id_usuario", nullable = false)
    private Long userId;

    @Column(name = "numero_tarjeta", unique = true, nullable = false)
    private String cardNumber;

    @Column(name = "id_tipo_tarjeta", nullable = false)
    private Byte cardTypeId;

    @Column(nullable = false)
    private String cvv;

    @Column(name = "fecha_expiracion", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "id_estado_tarjeta", nullable = false)
    private Byte cardStatusId;
}
