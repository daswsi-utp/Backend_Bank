package com.bank.service_card.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tarjetas", indexes = {
        @Index(name = "idx_usuario_tarjeta", columnList = "id_usuario"),
        @Index(name = "idx_numero_tarjeta", columnList = "numero_tarjeta")
})
@Getter
@Setter
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

    @Column(name = "id_cuenta_asociada")
    private Long associatedAccountId;

    @Column(name = "numero_tarjeta", nullable = false, unique = true, length = 16)
    private String cardNumber;

    // Este campo es generado automáticamente por la BD, no lo mapeamos directamente
    @Column(name = "numero_enmascarado", insertable = false, updatable = false)
    private String maskedNumber;

    @Column(name = "id_tipo_tarjeta", nullable = false)
    private Byte cardTypeId;

    @Column(name = "nombre_titular", nullable = false, length = 150)
    private String cardHolderName;

    @Column(name = "fecha_expiracion", nullable = false)
    private LocalDate expirationDate;

    @Column(name = "id_estado_tarjeta")
    private Byte cardStatusId;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDate issueDate;

    @Column(name = "fecha_activacion")
    private LocalDate activationDate;
}
