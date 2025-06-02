package com.bank.service_employee.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "credenciales_empleado")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeCredential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_credencial")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", nullable = false)
    private Employee empleado;

    @Column(name = "hash_contrasena", nullable = false)
    private String passwordHash;

    private String rol;

    @Column(name = "esta_activo")
    private Boolean active = true;

    @Column(name = "intentos_fallidos")
    private Integer failedAttempts = 0;

    @Column(name = "cuenta_bloqueada")
    private Boolean blocked = false;
}
