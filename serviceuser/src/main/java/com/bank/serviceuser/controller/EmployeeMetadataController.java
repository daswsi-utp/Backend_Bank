package com.bank.serviceuser.controller;

import com.bank.serviceuser.dto.EmpleadoMetadataRequestDTO;
import com.bank.serviceuser.dto.EmpleadoMetadataResponseDTO;
import com.bank.serviceuser.service.EmployeeMetadataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees/metadata")
@RequiredArgsConstructor
public class EmployeeMetadataController {

    private final EmployeeMetadataService metadataService;

    @PostMapping
    public ResponseEntity<EmpleadoMetadataResponseDTO> createMetadata(@Valid @RequestBody EmpleadoMetadataRequestDTO requestDTO) {
        return ResponseEntity.ok(metadataService.createMetadata(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoMetadataResponseDTO> getMetadataById(@PathVariable Long id) {
        return metadataService.getMetadataById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoMetadataResponseDTO> updateMetadata(@PathVariable Long id, @Valid @RequestBody EmpleadoMetadataRequestDTO requestDTO) {
        return ResponseEntity.ok(metadataService.updateMetadata(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetadata(@PathVariable Long id) {
        metadataService.deleteMetadata(id);
        return ResponseEntity.noContent().build();
    }
}
