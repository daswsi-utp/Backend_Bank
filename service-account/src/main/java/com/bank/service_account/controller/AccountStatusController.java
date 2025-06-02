package com.bank.service_account.controller;

import com.bank.service_account.model.AccountStatus;
import com.bank.service_account.service.AccountStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account-statuses")
@RequiredArgsConstructor
public class AccountStatusController {

    private final AccountStatusService accountStatusService;

    @GetMapping
    public ResponseEntity<List<AccountStatus>> getAllAccountStatuses() {
        return ResponseEntity.ok(accountStatusService.getAllAccountStatuses());
    }
}

