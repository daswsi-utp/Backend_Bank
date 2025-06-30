package com.bank.service_loan.controller;

import com.bank.service_loan.dto.LoanInstallmentRequestDTO;
import com.bank.service_loan.dto.LoanInstallmentResponseDTO;
import com.bank.service_loan.service.LoanInstallmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/installments")
@RequiredArgsConstructor
public class LoanInstallmentController {

    private final LoanInstallmentService installmentService;

    @PostMapping
    public ResponseEntity<LoanInstallmentResponseDTO> createInstallment(@RequestBody LoanInstallmentRequestDTO dto) {
        return ResponseEntity.ok(installmentService.createInstallment(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanInstallmentResponseDTO> getInstallmentById(@PathVariable Long id) {
        LoanInstallmentResponseDTO dto = installmentService.getInstallmentById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/loan/{loanId}")
    public ResponseEntity<List<LoanInstallmentResponseDTO>> getByLoanId(@PathVariable Long loanId) {
        return ResponseEntity.ok(installmentService.getInstallmentsByLoanId(loanId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanInstallmentResponseDTO> updateInstallment(@PathVariable Long id, @RequestBody LoanInstallmentRequestDTO dto) {
        LoanInstallmentResponseDTO updated = installmentService.updateInstallment(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstallment(@PathVariable Long id) {
        installmentService.deleteInstallment(id);
        return ResponseEntity.noContent().build();
    }
}
