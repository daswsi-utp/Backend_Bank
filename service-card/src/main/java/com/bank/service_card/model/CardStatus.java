package com.bank.service_card.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estados_tarjeta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CardStatus {

    @Id
    @Column(name = "id_estado")
    private Byte id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;
}
