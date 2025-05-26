
package com.bank.service_card.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TarjetaResponseDTO {
    private Long id;
    private String numeroTarjeta;
    private String cvv;
    private LocalDate fechaExpiracion;
    private Byte idEstadoTarjeta;
}
