package com.bank.service_employee.serviceimpl;

import com.bank.service_employee.dto.EmployeeRequestDTO;
import com.bank.service_employee.dto.EmployeeResponseDTO;
import com.bank.service_employee.model.Employee;
import com.bank.service_employee.repository.EmployeeRepository;
import com.bank.service_employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto) {
        Employee employee = Employee.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .email(dto.getEmail())
                .dni(dto.getDni())
                .telefono(dto.getTelefono())
                .area(dto.getArea())
                .cargo(dto.getCargo())
                .fechaIngreso(dto.getFechaIngreso())
                .build();

        return toDto(employeeRepository.save(employee));
    }

    @Override
    public Optional<EmployeeResponseDTO> getEmployeeById(Long id) {
        return employeeRepository.findById(id).map(this::toDto);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::toDto).toList();
    }

    @Override
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        employee.setNombre(dto.getNombre());
        employee.setApellido(dto.getApellido());
        employee.setEmail(dto.getEmail());
        employee.setDni(dto.getDni());
        employee.setTelefono(dto.getTelefono());
        employee.setArea(dto.getArea());
        employee.setCargo(dto.getCargo());
        employee.setFechaIngreso(dto.getFechaIngreso());

        return toDto(employeeRepository.save(employee));
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    private EmployeeResponseDTO toDto(Employee emp) {
        return EmployeeResponseDTO.builder()
                .id(emp.getId())
                .nombreCompleto(emp.getNombre() + " " + emp.getApellido())
                .email(emp.getEmail())
                .dni(emp.getDni())
                .telefono(emp.getTelefono())
                .area(emp.getArea())
                .cargo(emp.getCargo())
                .fechaIngreso(emp.getFechaIngreso())
                .build();
    }
}
