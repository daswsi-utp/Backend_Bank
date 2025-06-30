package com.bank.service_account.controller;

import com.bank.service_account.dto.*;
import com.bank.service_account.service.AccountMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account-movements")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // CORS permitido para pruebas
public class AccountMovementController {

    private final AccountMovementService movementService;

    @PostMapping
    public ResponseEntity<AccountMovementDTO> createMovement(@RequestBody CreateAccountMovementDTO dto) {
        return ResponseEntity.ok(movementService.createMovement(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountMovementDTO> getMovementById(@PathVariable Long id) {
        return ResponseEntity.ok(movementService.getMovementById(id));
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<AccountMovementDTO>> getMovementsByAccountId(@PathVariable Long accountId) {
        return ResponseEntity.ok(movementService.getMovementsByAccountId(accountId));
    }
}
