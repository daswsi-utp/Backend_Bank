package com.bank.service_transfer.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transfer_limits")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferLimit {

    @Id
    @Column(name = "account_id")
    private Long accountId; // ← corregido

    @Column(name = "daily_limit", nullable = false)
    private BigDecimal dailyLimit;
}
