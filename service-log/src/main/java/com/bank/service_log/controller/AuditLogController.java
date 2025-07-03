package com.bank.service_log.controller;

import com.bank.service_log.dto.AuditLogRequestDTO;
import com.bank.service_log.dto.AuditLogResponseDTO;
import com.bank.service_log.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor // Permitir peticiones desde cualquier origen (útil para Postman o frontend)
public class AuditLogController {

    private final AuditLogService auditLogService;

    // ✅ Crear un log
    @PostMapping
    public ResponseEntity<AuditLogResponseDTO> createLog(@RequestBody AuditLogRequestDTO requestDTO) {
        return ResponseEntity.ok(auditLogService.createLog(requestDTO));
    }

    // ✅ Obtener un log por ID
    @GetMapping("/{id}")
    public ResponseEntity<AuditLogResponseDTO> getLogById(@PathVariable Long id) {
        return ResponseEntity.ok(auditLogService.getLogById(id));
    }

    // ✅ Obtener todos los logs
    @GetMapping
    public ResponseEntity<List<AuditLogResponseDTO>> getAllLogs() {
        return ResponseEntity.ok(auditLogService.getAllLogs());
    }

    // ✅ Actualizar un log
    @PutMapping("/{id}")
    public ResponseEntity<AuditLogResponseDTO> updateLog(@PathVariable Long id, @RequestBody AuditLogRequestDTO requestDTO) {
        return ResponseEntity.ok(auditLogService.updateLog(id, requestDTO));
    }

    // ✅ Eliminar un log
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        auditLogService.deleteLog(id);
        return ResponseEntity.noContent().build();
    }
}
