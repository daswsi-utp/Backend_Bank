package com.bank.service_employee.controller;

import com.bank.service_employee.dto.EmployeeCredentialDTO;
import com.bank.service_employee.dto.LoginRequest;
import com.bank.service_employee.service.EmployeeCredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee-credentials")
@RequiredArgsConstructor
public class EmployeeCredentialController {

    private final EmployeeCredentialService credentialService;

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<EmployeeCredentialDTO> getByEmployeeId(@PathVariable Long employeeId) {
        return credentialService.getCredentialByEmployeeId(employeeId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
    return credentialService.login(request.getEmail(), request.getPassword())
            .<ResponseEntity<Object>>map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.status(401).body("Credenciales inválidas"));
}

}
