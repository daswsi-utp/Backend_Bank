
package com.bank.service_card.service;

import com.bank.servicecard.dto.MovimientoTarjetaDTO;
import com.bank.servicecard.dto.TarjetaRequestDTO;
import com.bank.servicecard.dto.TarjetaResponseDTO;

import java.util.List;

public interface TarjetaService {
    TarjetaResponseDTO emitirTarjeta(TarjetaRequestDTO request);
    List<TarjetaResponseDTO> obtenerTarjetasPorUsuario(Long idUsuario);
    TarjetaResponseDTO activarTarjeta(Long idTarjeta);
    List<MovimientoTarjetaDTO> obtenerMovimientosPorTarjeta(Long idTarjeta);
}

