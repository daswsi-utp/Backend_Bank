package com.bank.service_employee.service;

import com.bank.service_employee.dto.EmployeeCredentialDTO;
import com.bank.service_employee.dto.LoginResponse;

import java.util.Optional;

public interface EmployeeCredentialService {
    Optional<EmployeeCredentialDTO> getCredentialByEmployeeId(Long employeeId);
    Optional<LoginResponse> login(String email, String password);
}
