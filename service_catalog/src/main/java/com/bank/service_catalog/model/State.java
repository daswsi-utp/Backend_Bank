package com.bank.service_catalog.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estados", uniqueConstraints = {
        @UniqueConstraint(name = "uk_estado_modulo", columnNames = {"modulo", "nombre"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado")
    private Byte id;

    @Column(name = "modulo", nullable = false, length = 50)
    private String module;

    @Column(name = "nombre", nullable = false, length = 50)
    private String name;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String description;

    @Column(name = "es_activo", nullable = false)
    private Boolean isActive = true;
}
