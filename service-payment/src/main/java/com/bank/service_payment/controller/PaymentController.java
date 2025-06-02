package com.bank.service_payment.controller;

import com.bank.service_payment.dto.PaymentRequestDTO;
import com.bank.service_payment.dto.PaymentResponseDTO;
import com.bank.service_payment.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> registerPayment(@Valid @RequestBody PaymentRequestDTO dto) {
        return ResponseEntity.ok(paymentService.registerPayment(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<PaymentResponseDTO>> getPaymentsByAccountId(@PathVariable Long accountId) {
        return ResponseEntity.ok(paymentService.getPaymentsByAccountId(accountId));
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponseDTO>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }
}
