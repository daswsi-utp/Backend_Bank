package com.bank.service_fraud.controller;

import com.bank.service_fraud.dto.FraudAlertRequestDTO;
import com.bank.service_fraud.dto.FraudAlertResponseDTO;
import com.bank.service_fraud.service.FraudAlertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
@RequiredArgsConstructor
public class FraudAlertController {

    private final FraudAlertService fraudAlertService;

    @PostMapping
    public ResponseEntity<FraudAlertResponseDTO> createAlert(@Valid @RequestBody FraudAlertRequestDTO dto) {
        return ResponseEntity.ok(fraudAlertService.createAlert(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudAlertResponseDTO> getById(@PathVariable Integer id) {
        return fraudAlertService.getAlertById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FraudAlertResponseDTO>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(fraudAlertService.getAlertsByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<FraudAlertResponseDTO>> getAll() {
        return ResponseEntity.ok(fraudAlertService.getAllAlerts());
    }

    @PutMapping("/{id}/confirm")
    public ResponseEntity<FraudAlertResponseDTO> confirmAlert(@PathVariable Integer id) {
        return ResponseEntity.ok(fraudAlertService.confirmAlert(id));
    }
}
