package com.bank.serviceuser.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    private String nombre;

    @Column(name = "ape_paterno")
    private String apellidoPaterno;

    @Column(name = "ape_materno")
    private String apellidoMaterno;

    private String email;

    private String telefono;

    private String dni;

    private String departamento;

    private String provincia;

    private String distrito;

    private String direccion;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;
}
