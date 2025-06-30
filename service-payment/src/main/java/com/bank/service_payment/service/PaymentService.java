package com.bank.service_payment.service;

import com.bank.service_payment.dto.CreatePaymentDTO;
import com.bank.service_payment.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    PaymentDTO createPayment(CreatePaymentDTO createPaymentDTO);
    List<PaymentDTO> getAllPayments();
    PaymentDTO getPaymentById(Long id);
    PaymentDTO getPaymentByReference(String referenceNumber);
    void deletePayment(Long id);
}
