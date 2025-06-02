package com.bank.service_loan.controller;

import com.bank.service_loan.model.LoanStatus;
import com.bank.service_loan.service.LoanStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan-statuses")
@RequiredArgsConstructor
public class LoanStatusController {

    private final LoanStatusService loanStatusService;

    @GetMapping
    public ResponseEntity<List<LoanStatus>> getAllStatuses() {
        return ResponseEntity.ok(loanStatusService.getAllStatuses());
    }
}
