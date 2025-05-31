package com.bank.service_transfer.controller;

import com.bank.service_transfer.model.TransferLimit;
import com.bank.service_transfer.service.TransferLimitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/transfer-limits")
@RequiredArgsConstructor
public class TransferLimitController {

    private final TransferLimitService transferLimitService;

    @PostMapping
    public ResponseEntity<TransferLimit> createTransferLimit(@Valid @RequestBody TransferLimit transferLimit) {
        return ResponseEntity.ok(transferLimitService.createTransferLimit(transferLimit));
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<TransferLimit> getTransferLimitByAccountId(@PathVariable String accountId) {
        return transferLimitService.getTransferLimitByAccountId(accountId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<TransferLimit> updateTransferLimit(
            @PathVariable String accountId,
            @RequestParam BigDecimal newLimit) {
        return ResponseEntity.ok(transferLimitService.updateTransferLimit(accountId, newLimit));
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteTransferLimit(@PathVariable String accountId) {
        transferLimitService.deleteTransferLimit(accountId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{accountId}/remaining")
    public ResponseEntity<BigDecimal> getRemainingDailyLimit(@PathVariable String accountId) {
        return ResponseEntity.ok(transferLimitService.getRemainingDailyLimit(accountId));
    }

    @GetMapping("/range")
    public ResponseEntity<List<TransferLimit>> getLimitsByAmountRange(
            @RequestParam BigDecimal minAmount,
            @RequestParam BigDecimal maxAmount) {
        return ResponseEntity.ok(transferLimitService.getLimitsByAmountRange(minAmount, maxAmount));
    }

    @GetMapping("/exceeding")
    public ResponseEntity<List<TransferLimit>> getAccountsExceedingLimit(@RequestParam BigDecimal amount) {
        return ResponseEntity.ok(transferLimitService.getAccountsExceedingLimit(amount));
    }

    @GetMapping("/{accountId}/validate")
    public ResponseEntity<Boolean> validateTransfer(
            @PathVariable String accountId,
            @RequestParam BigDecimal amount) {
        return ResponseEntity.ok(transferLimitService.isTransferAllowed(accountId, amount));
    }
}
