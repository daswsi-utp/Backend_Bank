package com.bank.service_transfer.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "limites_transferencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferLimit {

    @Id
    @Column(name = "id_usuario")
    private Long userId;

    @Column(name = "limite_diario")
    private BigDecimal dailyLimit;

    @Column(name = "limite_por_transferencia")
    private BigDecimal perTransferLimit;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @PrePersist
    @PreUpdate
    public void updateTimestamp() {
        this.fechaActualizacion = LocalDateTime.now();
    }
}
