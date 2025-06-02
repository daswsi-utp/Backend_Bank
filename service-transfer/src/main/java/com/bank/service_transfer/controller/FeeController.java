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

    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<List<Fee>> getByTransaction(@PathVariable Long transactionId) {
        return ResponseEntity.ok(feeService.getFeesByTransactionId(transactionId));
    }

    @GetMapping("/range")
    public ResponseEntity<List<Fee>> getByAmountRange(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {
        return ResponseEntity.ok(feeService.getFeesByAmountRange(min, max));
    }

    @GetMapping("/total")
    public ResponseEntity<BigDecimal> getTotalCollected() {
        return ResponseEntity.ok(feeService.getTotalFeesCollected());
    }
}
