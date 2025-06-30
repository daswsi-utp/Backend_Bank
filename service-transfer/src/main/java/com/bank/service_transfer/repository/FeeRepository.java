package com.bank.service_transfer.repository;

import com.bank.service_transfer.model.Fee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeRepository extends JpaRepository<Fee, Long> {

    // Buscar todas las comisiones de una transferencia
    List<Fee> findByTransferId(Long transferId);
}
