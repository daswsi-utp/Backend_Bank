
package com.bank.service_card.repository;

import com.bank.servicecard.model.MovimientoTarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimientoTarjetaRepository extends JpaRepository<MovimientoTarjeta, Long> {
    List<MovimientoTarjeta> findByIdTarjeta(Long idTarjeta);
}

