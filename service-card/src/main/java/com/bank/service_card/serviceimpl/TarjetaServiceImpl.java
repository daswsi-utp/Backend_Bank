
package com.bank.service_card.serviceimpl;


import com.bank.servicecard.dto.MovimientoTarjetaDTO;
import com.bank.servicecard.dto.TarjetaRequestDTO;
import com.bank.servicecard.dto.TarjetaResponseDTO;
import com.bank.servicecard.exception.ResourceNotFoundException;
import com.bank.servicecard.exception.TarjetaYaActivaException;
import com.bank.servicecard.model.MovimientoTarjeta;
import com.bank.servicecard.model.Tarjeta;
import com.bank.servicecard.repository.MovimientoTarjetaRepository;
import com.bank.servicecard.repository.TarjetaRepository;
import com.bank.servicecard.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class TarjetaServiceImpl implements TarjetaService {

    private final TarjetaRepository tarjetaRepository;
    private final MovimientoTarjetaRepository movimientoRepository;

    @Autowired
    public TarjetaServiceImpl(TarjetaRepository tarjetaRepository, MovimientoTarjetaRepository movimientoRepository) {
        this.tarjetaRepository = tarjetaRepository;
        this.movimientoRepository = movimientoRepository;
    }

    @Override
    public TarjetaResponseDTO emitirTarjeta(TarjetaRequestDTO request) {
        boolean existe = tarjetaRepository.findByIdUsuario(request.getIdUsuario())
                .stream()
                .anyMatch(t -> t.getIdTipoTarjeta().equals(request.getIdTipoTarjeta()) && t.getIdEstadoTarjeta() == 1);

        if (existe) {
            throw new TarjetaYaActivaException("El usuario ya tiene una tarjeta activa de este tipo.");
        }

        Tarjeta tarjeta = Tarjeta.builder()
                .idUsuario(request.getIdUsuario())
                .idTipoTarjeta(request.getIdTipoTarjeta())
                .numeroTarjeta(generarNumeroTarjeta())
                .cvv(generarCVV())
                .fechaExpiracion(LocalDate.now().plusYears(4))
                .idEstadoTarjeta((byte) 1)
                .build();

        return mapToDTO(tarjetaRepository.save(tarjeta));
    }

    @Override
    public List<TarjetaResponseDTO> obtenerTarjetasPorUsuario(Long idUsuario) {
        return tarjetaRepository.findByIdUsuario(idUsuario)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TarjetaResponseDTO activarTarjeta(Long idTarjeta) {
        Tarjeta tarjeta = tarjetaRepository.findById(idTarjeta)
                .orElseThrow(() -> new ResourceNotFoundException("Tarjeta no encontrada"));
        tarjeta.setIdEstadoTarjeta((byte) 1);
        return mapToDTO(tarjetaRepository.save(tarjeta));
    }

    public TarjetaResponseDTO bloquearTarjeta(Long idTarjeta) {
        Tarjeta tarjeta = tarjetaRepository.findById(idTarjeta)
                .orElseThrow(() -> new ResourceNotFoundException("Tarjeta no encontrada"));
        tarjeta.setIdEstadoTarjeta((byte) 2);
        return mapToDTO(tarjetaRepository.save(tarjeta));
    }

    @Override
    public List<MovimientoTarjetaDTO> obtenerMovimientosPorTarjeta(Long idTarjeta) {
        return movimientoRepository.findByIdTarjeta(idTarjeta)
                .stream()
                .map(m -> {
                    MovimientoTarjetaDTO dto = new MovimientoTarjetaDTO();
                    dto.setIdTarjeta(m.getIdTarjeta());
                    dto.setMonto(m.getMonto());
                    dto.setComercio(m.getComercio());
                    dto.setUbicacion(m.getUbicacion());
                    dto.setFecha(m.getFecha());
                    return dto;
                }).collect(Collectors.toList());
    }

    private String generarNumeroTarjeta() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder("4"); // Visa prefix
        for (int i = 0; i < 15; i++) sb.append(r.nextInt(10));
        return sb.toString();
    }

    private String generarCVV() {
        return String.valueOf(100 + new Random().nextInt(900));
    }

    private TarjetaResponseDTO mapToDTO(Tarjeta tarjeta) {
        TarjetaResponseDTO dto = new TarjetaResponseDTO();
        dto.setId(tarjeta.getId());
        dto.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
        dto.setCvv(tarjeta.getCvv());
        dto.setFechaExpiracion(tarjeta.getFechaExpiracion());
        dto.setIdEstadoTarjeta(tarjeta.getIdEstadoTarjeta());
        return dto;
    }
}