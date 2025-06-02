package com.bank.service_loan.controller;

import com.bank.service_loan.dto.LoanPaymentDTO;
import com.bank.service_loan.service.LoanPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/loan-payments")
@RequiredArgsConstructor
public class LoanPaymentController {

    private final LoanPaymentService paymentService;

    @PostMapping("/{loanId}")
    public ResponseEntity<LoanPaymentDTO> registerPayment(
            @PathVariable Long loanId,
            @RequestParam BigDecimal amount) {
        return ResponseEntity.ok(paymentService.registerPayment(loanId, amount));
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<List<LoanPaymentDTO>> getPaymentsByLoan(@PathVariable Long loanId) {
        return ResponseEntity.ok(paymentService.getPaymentsByLoanId(loanId));
    }
}
