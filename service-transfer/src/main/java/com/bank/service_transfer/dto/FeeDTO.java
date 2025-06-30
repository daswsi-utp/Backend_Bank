package com.bank.service_transfer.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeeDTO {
    private Long id;
    private Long transferId;
    private BigDecimal monto;
    private String tipo;
    private String descripcion;
}
