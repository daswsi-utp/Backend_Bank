package com.bank.service_transfer.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Entity class representing a money transfer transaction between accounts
 */
@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "source_account_id", nullable = false)
    private String sourceAccountId;

    @Column(name = "destination_account_id", nullable = false)
    private String destinationAccountId;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column
    private LocalDateTime date = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column
    private TransactionStatus status = TransactionStatus.PENDING;

    @Column
    private String reference;

    // Enum for transaction status
    public enum TransactionStatus {
        PENDING, COMPLETED, FAILED
    }
}
