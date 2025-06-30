package com.bank.service_card.controller;

import com.bank.service_card.dto.CardTransactionDTO;
import com.bank.service_card.dto.CardTransactionRequestDTO;
import com.bank.service_card.service.CardTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class CardTransactionController {

    private final CardTransactionService transactionService;

    @PostMapping
    public ResponseEntity<CardTransactionDTO> create(@RequestBody CardTransactionRequestDTO request) {
        return ResponseEntity.ok(transactionService.createTransaction(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardTransactionDTO> getById(@PathVariable Long id) {
        CardTransactionDTO tx = transactionService.getTransactionById(id);
        return tx != null ? ResponseEntity.ok(tx) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<CardTransactionDTO>> getAll() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/card/{cardId}")
    public ResponseEntity<List<CardTransactionDTO>> getByCardId(@PathVariable Long cardId) {
        return ResponseEntity.ok(transactionService.getTransactionsByCardId(cardId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }
}
