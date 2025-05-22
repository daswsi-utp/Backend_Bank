package com.bank.serviceuser.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "credenciales")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credencial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credencial")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "hash_contrasena")
    private String passwordHash;

    @Column(name = "dos_factores_activado")
    private Boolean dosFactoresActivado;

    @Column(name = "ultimo_login")
    private LocalDateTime ultimoLogin;
}
