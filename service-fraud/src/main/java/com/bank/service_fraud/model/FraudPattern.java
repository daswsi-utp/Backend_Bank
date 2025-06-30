package com.bank.service_fraud.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "patrones_fraude")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudPattern {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patron")
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "descripcion", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "reglas", columnDefinition = "JSON", nullable = false)
    private String rules;

    @Enumerated(EnumType.STRING)
    @Column(name = "severidad", nullable = false)
    private Severity severity;

    @Column(name = "esta_activo")
    private Boolean isActive;
}
