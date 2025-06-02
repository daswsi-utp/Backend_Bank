package com.bank.service_fraud.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipos_transaccion_alerta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionAlertType {

    @Id
    @Column(name = "id_tipo_transaccion")
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;
}
