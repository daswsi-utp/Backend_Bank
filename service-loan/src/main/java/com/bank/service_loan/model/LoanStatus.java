package com.bank.service_loan.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estados_prestamo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanStatus {

    @Id
    @Column(name = "id_estado")
    private Byte id;

    @Column(nullable = false, unique = true)
    private String name;
}
