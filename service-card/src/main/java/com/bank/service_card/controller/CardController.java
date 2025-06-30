package com.bank.service_card.controller;

import com.bank.service_card.dto.CardDTO;
import com.bank.service_card.dto.CardRequestDTO;
import com.bank.service_card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardDTO> create(@RequestBody CardRequestDTO request) {
        return ResponseEntity.ok(cardService.createCard(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDTO> getById(@PathVariable Long id) {
        CardDTO card = cardService.getCardById(id);
        return card != null ? ResponseEntity.ok(card) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<CardDTO>> getAll() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CardDTO>> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(cardService.getCardsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardDTO> update(@PathVariable Long id, @RequestBody CardRequestDTO request) {
        CardDTO updated = cardService.updateCard(id, request);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }
}
