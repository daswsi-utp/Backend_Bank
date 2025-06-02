package com.bank.service_employee.serviceimpl;

import com.bank.service_employee.dto.EmployeeCredentialDTO;
import com.bank.service_employee.model.EmployeeCredential;
import com.bank.service_employee.repository.EmployeeCredentialRepository;
import com.bank.service_employee.service.EmployeeCredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeCredentialServiceImpl implements EmployeeCredentialService {

    private final EmployeeCredentialRepository credentialRepository;

    @Override
    public Optional<EmployeeCredentialDTO> getCredentialByEmployeeId(Long employeeId) {
        return credentialRepository.findByEmpleadoId(employeeId).map(this::toDto);
    }

    private EmployeeCredentialDTO toDto(EmployeeCredential entity) {
        EmployeeCredentialDTO dto = new EmployeeCredentialDTO();
        dto.setId(entity.getId());
        dto.setEmployeeId(entity.getEmpleado().getId());
        dto.setRol(entity.getRol());
        dto.setActive(entity.getActive());
        dto.setBlocked(entity.getBlocked());
        dto.setFailedAttempts(entity.getFailedAttempts());
        return dto;
    }
}
