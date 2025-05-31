
package com.bank.service_card.controller;

import com.bank.servicecard.dto.MovimientoTarjetaDTO;
import com.bank.servicecard.dto.TarjetaRequestDTO;
import com.bank.servicecard.dto.TarjetaResponseDTO;
import com.bank.servicecard.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarjetas")
public class TarjetaController {

    private final TarjetaService tarjetaService;

    @Autowired
    public TarjetaController(TarjetaService tarjetaService) {
        this.tarjetaService = tarjetaService;
    }

    @PostMapping
    public ResponseEntity<TarjetaResponseDTO> emitir(@RequestBody TarjetaRequestDTO request) {
        return ResponseEntity.ok(tarjetaService.emitirTarjeta(request));
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<TarjetaResponseDTO>> obtenerPorUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(tarjetaService.obtenerTarjetasPorUsuario(idUsuario));
    }

    @PutMapping("/{idTarjeta}/activar")
    public ResponseEntity<TarjetaResponseDTO> activar(@PathVariable Long idTarjeta) {
        return ResponseEntity.ok(tarjetaService.activarTarjeta(idTarjeta));
    }

    @PutMapping("/{idTarjeta}/bloquear")
    public ResponseEntity<TarjetaResponseDTO> bloquear(@PathVariable Long idTarjeta) {
        return ResponseEntity.ok(tarjetaService.bloquearTarjeta(idTarjeta));
    }

    @GetMapping("/{idTarjeta}/movimientos")
    public ResponseEntity<List<MovimientoTarjetaDTO>> movimientos(@PathVariable Long idTarjeta) {
        return ResponseEntity.ok(tarjetaService.obtenerMovimientosPorTarjeta(idTarjeta));
    }
}
