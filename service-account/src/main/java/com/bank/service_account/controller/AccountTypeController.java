package com.bank.service_account.controller;

import com.bank.service_account.model.AccountType;
import com.bank.service_account.service.AccountTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account-types")
@RequiredArgsConstructor
public class AccountTypeController {

    private final AccountTypeService accountTypeService;

    @GetMapping
    public ResponseEntity<List<AccountType>> getAllAccountTypes() {
        return ResponseEntity.ok(accountTypeService.getAllAccountTypes());
    }
}
