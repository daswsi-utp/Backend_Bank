package com.bank.service_transfer.controller;

import com.bank.service_transfer.dto.TransferRequestDTO;
import com.bank.service_transfer.dto.TransferResponseDTO;
import com.bank.service_transfer.service.TransactionService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<TransferResponseDTO> createTransfer(@Valid @RequestBody TransferRequestDTO dto) {
        return ResponseEntity.ok(transactionService.createTransfer(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferResponseDTO> getTransferById(@PathVariable Long id) {
        return transactionService.getTransferById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/source/{accountId}")
    public ResponseEntity<List<TransferResponseDTO>> getTransfersBySource(@PathVariable Long accountId) {
        return ResponseEntity.ok(transactionService.getTransfersBySourceAccount(accountId));
    }

    @GetMapping("/destination/{accountId}")
    public ResponseEntity<List<TransferResponseDTO>> getTransfersByDestination(@PathVariable Long accountId) {
        return ResponseEntity.ok(transactionService.getTransfersByDestinationAccount(accountId));
    }

    @GetMapping("/range")
public ResponseEntity<List<TransferResponseDTO>> getTransfersByDateRange(
        @RequestParam String from,
        @RequestParam String to) {
    try {
        LocalDateTime fromDate = LocalDate.parse(from).atStartOfDay();
        LocalDateTime toDate = LocalDate.parse(to).atTime(23, 59, 59);

        return ResponseEntity.ok(transactionService.getTransfersByDateRange(fromDate, toDate));
    } catch (DateTimeParseException e) {
        return ResponseEntity.badRequest().build();
    }
}


    @PutMapping("/{id}/status/{statusId}")
    public ResponseEntity<TransferResponseDTO> updateStatus(@PathVariable Long id, @PathVariable Byte statusId) {
        return ResponseEntity.ok(transactionService.updateTransferStatus(id, statusId));
    }
}
