package com.bank.service_card.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipos_tarjeta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardType {

    @Id
    @Column(name = "id_tipo_tarjeta")
    private Byte id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;
}
