package com.bank.service_fraud.controller;

import com.bank.service_fraud.dto.FraudPatternDTO;
import com.bank.service_fraud.service.FraudPatternService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fraud-patterns")
@RequiredArgsConstructor
public class FraudPatternController {

    private final FraudPatternService patternService;

    @GetMapping
    public ResponseEntity<List<FraudPatternDTO>> getAllPatterns() {
        return ResponseEntity.ok(patternService.getAllPatterns());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudPatternDTO> getPatternById(@PathVariable Integer id) {
        FraudPatternDTO dto = patternService.getPatternById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<FraudPatternDTO>> getActivePatterns() {
        return ResponseEntity.ok(patternService.getActivePatterns());
    }

    @PostMapping
    public ResponseEntity<FraudPatternDTO> createPattern(@RequestBody FraudPatternDTO dto) {
        return ResponseEntity.ok(patternService.createPattern(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FraudPatternDTO> updatePattern(@PathVariable Integer id, @RequestBody FraudPatternDTO dto) {
        FraudPatternDTO updated = patternService.updatePattern(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePattern(@PathVariable Integer id) {
        patternService.deletePattern(id);
        return ResponseEntity.noContent().build();
    }
}
