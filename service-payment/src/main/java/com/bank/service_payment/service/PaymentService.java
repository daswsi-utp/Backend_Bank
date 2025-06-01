package com.bank.service_payment.service;

import com.bank.service_payment.dto.PaymentRequestDTO;
import com.bank.service_payment.dto.PaymentResponseDTO;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    PaymentResponseDTO registerPayment(PaymentRequestDTO dto);
    Optional<PaymentResponseDTO> getPaymentById(Long id);
    List<PaymentResponseDTO> getPaymentsByAccountId(Long accountId);
    List<PaymentResponseDTO> getAllPayments();
}
