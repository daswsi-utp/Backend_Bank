package com.bank.service_log.controller;

import com.bank.service_log.dto.LogRequestDTO;
import com.bank.service_log.dto.LogResponseDTO;
import com.bank.service_log.service.LogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @PostMapping
    public ResponseEntity<LogResponseDTO> saveLog(@Valid @RequestBody LogRequestDTO dto) {
        return ResponseEntity.ok(logService.saveLog(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogResponseDTO> getLogById(@PathVariable Long id) {
        return logService.getLogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LogResponseDTO>> getLogsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(logService.getLogsByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<LogResponseDTO>> getAllLogs() {
        return ResponseEntity.ok(logService.getAllLogs());
    }
}
