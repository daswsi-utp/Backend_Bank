
package com.bank.service_card.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MovimientoTarjetaDTO {
    private Long idTarjeta;
    private BigDecimal monto;
    private String comercio;
    private String ubicacion;
    private LocalDateTime fecha;
}

