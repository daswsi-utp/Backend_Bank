package com.bank.service_account.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estados_cuenta")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountStatus {

    @Id
    @Column(name = "id_estado")
    private Byte id;

    @Column(nullable = false, unique = true, length = 50)
    private String name;
}
