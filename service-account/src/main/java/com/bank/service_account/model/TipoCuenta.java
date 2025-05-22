package com.bank.service_account.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipos_cuenta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoCuenta {

    @Id
    @Column(name = "id_tipo_cuenta")
    private Byte id;

    @Column(nullable = false, unique = true, length = 50)
    private String nombre;
}
