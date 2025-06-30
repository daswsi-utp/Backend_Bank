package com.bank.service_transfer.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferLimitDTO {
    private Long userId;
    private BigDecimal dailyLimit;
    private BigDecimal perTransferLimit;
    private LocalDateTime fechaActualizacion;
}
