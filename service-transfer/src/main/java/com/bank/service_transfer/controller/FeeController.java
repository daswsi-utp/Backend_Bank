package com.bank.service_transfer.controller;

import com.bank.service_transfer.model.Fee;
import com.bank.service_transfer.service.FeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/fees")
@RequiredArgsConstructor
public class FeeController {

    private final FeeService feeService;

    @GetMapping("/{id}")
    public ResponseEntity<Fee> getFeeById(@PathVariable Long id) {
        return feeService.getFeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<List<Fee>> getFeesByTransactionId(@PathVariable Long transactionId) {
        return ResponseEntity.ok(feeService.getFeesByTransactionId(transactionId));
    }

    @GetMapping("/transaction/{transactionId}/total")
    public ResponseEntity<BigDecimal> getTotalFeesByTransactionId(@PathVariable Long transactionId) {
        return ResponseEntity.ok(feeService.getTotalFeesByTransactionId(transactionId));
    }

    @GetMapping("/range")
    public ResponseEntity<List<Fee>> getFeesByAmountRange(
            @RequestParam BigDecimal minAmount,
            @RequestParam BigDecimal maxAmount) {
        return ResponseEntity.ok(feeService.getFeesByAmountRange(minAmount, maxAmount));
    }

    @GetMapping("/total")
    public ResponseEntity<BigDecimal> getTotalFeesCollected() {
        return ResponseEntity.ok(feeService.getTotalFeesCollected());
    }
}
