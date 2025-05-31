package com.bank.service_transfer.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

/**
 * Entity class representing daily transfer limits for accounts
 */
@Data
@Entity
@Table(name = "transfer_limits")
public class TransferLimit {
    @Id
    @Column(name = "account_id")
    private String accountId;

    @Column(name = "daily_limit", nullable = false)
    private BigDecimal dailyLimit;
}
