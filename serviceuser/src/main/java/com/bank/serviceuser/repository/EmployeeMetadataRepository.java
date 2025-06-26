package com.bank.serviceuser.repository;

import com.bank.serviceuser.model.EmpleadoMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeMetadataRepository  extends JpaRepository<EmpleadoMetadata, Long> {
}

