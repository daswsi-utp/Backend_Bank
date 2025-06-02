package com.bank.service_card.controller;


import com.bank.service_card.dto.CardMovementRequestDTO;
import com.bank.service_card.dto.CardMovementResponseDTO;
import com.bank.service_card.service.CardMovementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movements")
@RequiredArgsConstructor
public class CardMovementController {

    private final CardMovementService movementService;

    @PostMapping
    public ResponseEntity<CardMovementResponseDTO> register(@Valid @RequestBody CardMovementRequestDTO dto) {
        return ResponseEntity.ok(movementService.registerMovement(dto));
    }

    @GetMapping("/card/{cardId}")
    public ResponseEntity<List<CardMovementResponseDTO>> getByCard(@PathVariable Long cardId) {
        return ResponseEntity.ok(movementService.getMovementsByCardId(cardId));
    }
}
