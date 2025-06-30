package com.bank.service_catalog.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "tipos", uniqueConstraints = {
        @UniqueConstraint(name = "uk_tipo_modulo", columnNames = {"modulo", "nombre"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Byte id;

    @Column(name = "modulo", nullable = false, length = 50)
    private String module;

    @Column(name = "nombre", nullable = false, length = 50)
    private String name;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String description;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "parametros", columnDefinition = "json")
    private String parameters; // o usar Map<String, Object> con Jackson
}
