
package com.bank.service_card.repository;

import com.bank.servicecard.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {
    List<Tarjeta> findByIdUsuario(Long idUsuario);
    Optional<Tarjeta> findByNumeroTarjeta(String numeroTarjeta);
}

