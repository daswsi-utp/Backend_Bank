package com.bank.service_transfer.repository;

import com.bank.service_transfer.model.TransferStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferStatusRepository extends JpaRepository<TransferStatus, Byte> {
}
