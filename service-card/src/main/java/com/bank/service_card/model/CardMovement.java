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
public class CardMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_movimiento")
    private Long id;

    @Column(name = "id_tarjeta", nullable = false)
    private Long cardId;

    @Column(nullable = false)
    private BigDecimal amount;

    private String merchant;
    private String location;

    @Column(nullable = false)
    private LocalDateTime date;
}
