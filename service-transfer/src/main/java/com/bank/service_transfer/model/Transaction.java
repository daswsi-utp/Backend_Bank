package com.bank.service_transfer.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_account_id", nullable = false)
    private Long sourceAccountId; // ← corregido

    @Column(name = "destination_account_id", nullable = false)
    private Long destinationAccountId; // ← corregido

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name = "date", insertable = false, updatable = false)
    private LocalDateTime date;

   @Enumerated(EnumType.STRING)
@Column(name = "status")
private TransferStatus status;

    private String reference;
}
