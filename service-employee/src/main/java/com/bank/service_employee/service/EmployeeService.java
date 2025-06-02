package com.bank.service_employee.service;

import com.bank.service_employee.dto.EmployeeRequestDTO;
import com.bank.service_employee.dto.EmployeeResponseDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto);
    Optional<EmployeeResponseDTO> getEmployeeById(Long id);
    List<EmployeeResponseDTO> getAllEmployees();
    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto);
    void deleteEmployee(Long id);
}
