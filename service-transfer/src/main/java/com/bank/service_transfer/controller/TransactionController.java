package com.bank.service_transfer.controller;

import com.bank.service_transfer.dto.TransferRequestDTO;
import com.bank.service_transfer.dto.TransferResponseDTO;
import com.bank.service_transfer.model.Transaction;
import com.bank.service_transfer.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransferResponseDTO> createTransfer(@Valid @RequestBody TransferRequestDTO request) {
        return ResponseEntity.ok(transactionService.createTransfer(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferResponseDTO> getTransferById(@PathVariable Long id) {
        return transactionService.getTransferById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/source/{accountId}")
    public ResponseEntity<List<TransferResponseDTO>> getTransfersBySourceAccount(@PathVariable String accountId) {
        return ResponseEntity.ok(transactionService.getTransfersBySourceAccount(accountId));
    }

    @GetMapping("/destination/{accountId}")
    public ResponseEntity<List<TransferResponseDTO>> getTransfersByDestinationAccount(@PathVariable String accountId) {
        return ResponseEntity.ok(transactionService.getTransfersByDestinationAccount(accountId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TransferResponseDTO>> getTransfersByStatus(
            @PathVariable Transaction.TransactionStatus status) {
        return ResponseEntity.ok(transactionService.getTransfersByStatus(status));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<TransferResponseDTO>> getTransfersByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return ResponseEntity.ok(transactionService.getTransfersByDateRange(startDate, endDate));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TransferResponseDTO> updateTransferStatus(
            @PathVariable Long id,
            @RequestParam Transaction.TransactionStatus newStatus) {
        return ResponseEntity.ok(transactionService.updateTransferStatus(id, newStatus));
    }
}
