package com.bank.service_transfer.repository;

import com.bank.service_transfer.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    // Buscar por cuenta origen
    List<Transfer> findBySourceAccount(Long sourceAccount);

    // Buscar por cuenta destino
    List<Transfer> findByDestinationAccount(Long destinationAccount);

    // Buscar por estado
    List<Transfer> findByEstadoId(Byte estadoId);

    // Buscar por fecha de solicitud entre dos fechas
    List<Transfer> findByFechaSolicitudBetween(java.time.LocalDateTime start, java.time.LocalDateTime end);
}
