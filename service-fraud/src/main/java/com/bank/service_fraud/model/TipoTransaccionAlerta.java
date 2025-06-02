package com.bank.service_fraud.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipos_transaccion_alerta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoTransaccionAlerta {

    @Id
    @Column(name = "id_tipo_transaccion")
    private Integer id;

    @Column(unique = true, nullable = false, length = 50)
    private String nombre;
}