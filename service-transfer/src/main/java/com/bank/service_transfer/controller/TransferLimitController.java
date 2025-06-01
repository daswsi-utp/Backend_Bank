package com.bank.service_transfer.controller;

import com.bank.service_transfer.model.TransferLimit;
import com.bank.service_transfer.service.TransferLimitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/limits")
@RequiredArgsConstructor
public class TransferLimitController {

    private final TransferLimitService limitService;

    @PostMapping
    public ResponseEntity<TransferLimit> create(@RequestBody TransferLimit limit) {
        return ResponseEntity.ok(limitService.createTransferLimit(limit));
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<TransferLimit> getByAccount(@PathVariable Long accountId) {
        return limitService.getTransferLimitByAccountId(accountId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<TransferLimit> update(@PathVariable Long accountId, @RequestBody BigDecimal newLimit) {
        return ResponseEntity.ok(limitService.updateTransferLimit(accountId, newLimit));
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> delete(@PathVariable Long accountId) {
        limitService.deleteTransferLimit(accountId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{accountId}/available")
    public ResponseEntity<BigDecimal> getAvailableLimit(@PathVariable Long accountId) {
        return ResponseEntity.ok(limitService.getRemainingDailyLimit(accountId));
    }

    @GetMapping("/range")
    public ResponseEntity<List<TransferLimit>> getLimitsByRange(
            @RequestParam BigDecimal min,
            @RequestParam BigDecimal max) {
        return ResponseEntity.ok(limitService.getLimitsByAmountRange(min, max));
    }
}
