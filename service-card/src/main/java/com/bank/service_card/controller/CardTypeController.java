package com.bank.service_card.controller;

import com.bank.service_card.model.CardType;
import com.bank.service_card.service.CardTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card-types")
@RequiredArgsConstructor
public class CardTypeController {

    private final CardTypeService service;

    @GetMapping
    public ResponseEntity<List<CardType>> getAllTypes() {
        return ResponseEntity.ok(service.getAllCardTypes());
    }
}
