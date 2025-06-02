package com.bank.service_employee.service;

import com.bank.service_employee.dto.EmployeeCredentialDTO;

import java.util.Optional;

public interface EmployeeCredentialService {
    Optional<EmployeeCredentialDTO> getCredentialByEmployeeId(Long employeeId);
}
