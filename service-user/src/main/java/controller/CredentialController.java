package com.bank.serviceuser.controller;

import com.bank.serviceuser.model.Credencial;
import com.bank.serviceuser.service.CredentialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credentials")
public class CredentialController {

    private final CredentialService credentialService;

    @Autowired
    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping
    public ResponseEntity<Credencial> createCredential(@Valid @RequestBody Credencial credencial) {
        return ResponseEntity.ok(credentialService.createCredential(credencial));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Credencial> getCredentialByUserId(@PathVariable Long userId) {
        return credentialService.getCredentialByUserId(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
