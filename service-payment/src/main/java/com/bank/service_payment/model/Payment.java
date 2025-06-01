package com.bank.service_payment.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos_servicios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Long id;

    @Column(name = "id_cuenta", nullable = false)
    private Long accountId;

    @Column(nullable = false, length = 100)
    private String company;

    @Column(name = "numero_referencia", nullable = false, length = 50)
    private String referenceNumber;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @Column(name = "fecha", insertable = false, updatable = false)
    private LocalDateTime date;
}
