package com.bank.service_payment.dto;

import com.bank.service_payment.model.Payment;

public class PaymentMapper {

    public static Payment toEntity(PaymentRequestDTO dto) {
        return Payment.builder()
                .accountId(dto.getAccountId())
                .company(dto.getCompany())
                .referenceNumber(dto.getReferenceNumber())
                .amount(dto.getAmount())
                .build();
    }

    public static PaymentResponseDTO toDto(Payment payment) {
        return PaymentResponseDTO.builder()
                .id(payment.getId())
                .accountId(payment.getAccountId())
                .company(payment.getCompany())
                .referenceNumber(payment.getReferenceNumber())
                .amount(payment.getAmount())
                .date(payment.getDate())
                .build();
    }
}
