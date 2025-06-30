package com.bank.service_transfer.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferDTO {
    private Long id;
    private Long sourceAccount;
    private Long destinationAccount;
    private BigDecimal monto;
    private String moneda;
    private String concepto;
    private String referencia;
    private Byte estadoId;
    private LocalDateTime fechaSolicitud;
    private LocalDateTime fechaCompletada;
}
