package com.bank.service_fraud.controller;

import com.bank.service_fraud.dto.FraudAlertDTO;
import com.bank.service_fraud.service.FraudAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-alerts")
@RequiredArgsConstructor
public class FraudAlertController {

    private final FraudAlertService alertService;

    @GetMapping
    public ResponseEntity<List<FraudAlertDTO>> getAllAlerts() {
        return ResponseEntity.ok(alertService.getAllAlerts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudAlertDTO> getAlertById(@PathVariable Long id) {
        FraudAlertDTO dto = alertService.getAlertById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FraudAlertDTO>> getAlertsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(alertService.getAlertsByUserId(userId));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<FraudAlertDTO>> getAlertsByType(@PathVariable String type) {
        return ResponseEntity.ok(alertService.getAlertsByTransactionType(type));
    }

    @PostMapping
    public ResponseEntity<FraudAlertDTO> createAlert(@RequestBody FraudAlertDTO dto) {
        return ResponseEntity.ok(alertService.createAlert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FraudAlertDTO> updateAlert(@PathVariable Long id, @RequestBody FraudAlertDTO dto) {
        FraudAlertDTO updated = alertService.updateAlert(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long id) {
        alertService.deleteAlert(id);
        return ResponseEntity.noContent().build();
    }
}
