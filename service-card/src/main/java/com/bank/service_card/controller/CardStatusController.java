package com.bank.service_card.controller;

import com.bank.service_card.model.CardStatus;
import com.bank.service_card.service.CardStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card-statuses")
@RequiredArgsConstructor
public class CardStatusController {

    private final CardStatusService service;

    @GetMapping
    public ResponseEntity<List<CardStatus>> getAllStatuses() {
        return ResponseEntity.ok(service.getAllCardStatuses());
    }
}
