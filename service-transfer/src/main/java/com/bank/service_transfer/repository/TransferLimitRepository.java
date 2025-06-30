package com.bank.service_transfer.repository;

import com.bank.service_transfer.model.TransferLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferLimitRepository extends JpaRepository<TransferLimit, Long> {

    // Ya puedes usar findById(Long userId) directamente gracias a JpaRepository
    boolean existsByUserId(Long userId);
}
