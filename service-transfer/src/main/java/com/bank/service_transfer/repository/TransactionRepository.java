package com.bank.service_transfer.repository;

import com.bank.service_transfer.model.Transaction;
import com.bank.service_transfer.model.TransferStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Transacciones según cuenta origen
    List<Transaction> findBySourceAccountId(Long sourceAccountId);

    // Transacciones según cuenta destino
    List<Transaction> findByDestinationAccountId(Long destinationAccountId);

    // Transacciones por estado (usando entidad TransferStatus)
    List<Transaction> findByStatus(TransferStatus status);

    // Transacciones en un rango de fechas
    List<Transaction> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);

    // Transacciones por cuenta origen y rango de fechas
    List<Transaction> findBySourceAccountIdAndDateBetween(Long sourceAccountId, LocalDateTime startDate, LocalDateTime endDate);
}
