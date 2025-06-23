package com.bank.service_account.controller;

import com.bank.service_account.dto.*;
import com.bank.service_account.model.Account;
import com.bank.service_account.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(@Valid @RequestBody AccountRequestDTO request) {
        Account saved = accountService.createAccount(AccountMapper.toEntity(request));
        return ResponseEntity.ok(AccountMapper.toDto(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDTO> getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id)
                .map(AccountMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/number/{accountNumber}")
    public ResponseEntity<AccountResponseDTO> getAccountByNumber(@PathVariable String accountNumber) {
        return accountService.getAccountByNumber(accountNumber)
                .map(AccountMapper::toDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AccountResponseDTO>> getAccountsByUserId(@PathVariable Long userId) {
        List<AccountResponseDTO> accounts = accountService.getAccountsByUserId(userId)
                .stream()
                .map(AccountMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(accounts);
    }

    @GetMapping
public ResponseEntity<List<AccountResponseDTO>> getAllAccounts() {
    List<Account> cuentas = accountService.getAllAccounts();
    cuentas.forEach(c -> System.out.println("Cuenta: " + c.getId()));
    List<AccountResponseDTO> accounts = cuentas.stream()
            .map(AccountMapper::toDto)
            .collect(Collectors.toList());
    return ResponseEntity.ok(accounts);
}

}
