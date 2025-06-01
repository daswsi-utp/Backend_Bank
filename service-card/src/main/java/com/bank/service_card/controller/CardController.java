package com.bank.service_card.controller;

import com.bank.service_card.dto.CardRequestDTO;
import com.bank.service_card.dto.CardResponseDTO;
import com.bank.service_card.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseEntity<CardResponseDTO> createCard(@Valid @RequestBody CardRequestDTO dto) {
        return ResponseEntity.ok(cardService.createCard(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardResponseDTO> getCardById(@PathVariable Long id) {
        return cardService.getCardById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/number/{cardNumber}")
    public ResponseEntity<CardResponseDTO> getCardByNumber(@PathVariable String cardNumber) {
        return cardService.getCardByNumber(cardNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CardResponseDTO>> getCardsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(cardService.getCardsByUserId(userId));
    }

    @GetMapping
    public ResponseEntity<List<CardResponseDTO>> getAllCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }
}
