package com.bank.service_transfer.repository;

import com.bank.service_transfer.model.TransferLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface TransferLimitRepository extends JpaRepository<TransferLimit, Long> {

    // Límites mayores a cierto monto
    List<TransferLimit> findByDailyLimitGreaterThan(BigDecimal amount);

    // Límites menores a cierto monto
    List<TransferLimit> findByDailyLimitLessThan(BigDecimal amount);

    // Límites en un rango
    List<TransferLimit> findByDailyLimitBetween(BigDecimal min, BigDecimal max);
}
