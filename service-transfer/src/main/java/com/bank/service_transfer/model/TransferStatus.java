package com.bank.service_transfer.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estados_transferencia")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferStatus {

    @Id
    @Column(name = "id_estado")
    private Byte id;

    @Column(name = "nombre", nullable = false, unique = true, length = 50)
    private String name;
}
