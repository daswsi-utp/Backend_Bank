package com.bank.service_employee.repository;

import com.bank.service_employee.model.EmployeeCredential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeCredentialRepository extends JpaRepository<EmployeeCredential, Long> {
    Optional<EmployeeCredential> findByEmpleadoId(Long empleadoId);
    // repository/EmployeeCredentialRepository.java
EmployeeCredential findByEmpleado_Email(String email);

}
