package com.bank.service_loan.controller;

import com.bank.service_loan.dto.LoanRequestDTO;
import com.bank.service_loan.dto.LoanResponseDTO;
import com.bank.service_loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanResponseDTO> createLoan(@RequestBody LoanRequestDTO dto) {
        return ResponseEntity.ok(loanService.createLoan(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDTO> getLoanById(@PathVariable Long id) {
        LoanResponseDTO loan = loanService.getLoanById(id);
        return loan != null ? ResponseEntity.ok(loan) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<LoanResponseDTO>> getAllLoans() {
        return ResponseEntity.ok(loanService.getAllLoans());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LoanResponseDTO>> getLoansByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(loanService.getLoansByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanResponseDTO> updateLoan(@PathVariable Long id, @RequestBody LoanRequestDTO dto) {
        LoanResponseDTO updated = loanService.updateLoan(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoan(@PathVariable Long id) {
        loanService.deleteLoan(id);
        return ResponseEntity.noContent().build();
    }
}
