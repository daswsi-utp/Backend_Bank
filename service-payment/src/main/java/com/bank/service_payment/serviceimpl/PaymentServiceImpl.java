package com.bank.service_payment.serviceimpl;

import com.bank.service_payment.dto.*;
import com.bank.service_payment.model.Payment;
import com.bank.service_payment.repository.PaymentRepository;
import com.bank.service_payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.bank.service_payment.dto.PaymentMapper.*;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentResponseDTO registerPayment(PaymentRequestDTO dto) {
        Payment saved = paymentRepository.save(toEntity(dto));
        return toDto(saved);
    }

    @Override
    public Optional<PaymentResponseDTO> getPaymentById(Long id) {
        return paymentRepository.findById(id).map(PaymentMapper::toDto);
    }

    @Override
    public List<PaymentResponseDTO> getPaymentsByAccountId(Long accountId) {
        return paymentRepository.findByAccountId(accountId)
                .stream()
                .map(PaymentMapper::toDto)
                .toList();
    }

    @Override
    public List<PaymentResponseDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(PaymentMapper::toDto)
                .toList();
    }
}
