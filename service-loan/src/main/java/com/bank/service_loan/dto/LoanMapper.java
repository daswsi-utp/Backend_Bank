package com.bank.service_loan.dto;

import com.bank.service_loan.model.*;

public class LoanMapper {

    public static Loan toEntity(LoanRequestDTO dto, LoanStatus defaultStatus) {
        return Loan.builder()
                .userId(dto.getUserId())
                .requestedAmount(dto.getRequestedAmount())
                .interestRate(dto.getInterestRate())
                .installments(dto.getInstallments())
                .status(defaultStatus)
                .build();
    }

    public static LoanResponseDTO toDto(Loan loan) {
        return LoanResponseDTO.builder()
                .id(loan.getId())
                .userId(loan.getUserId())
                .requestedAmount(loan.getRequestedAmount())
                .approvedAmount(loan.getApprovedAmount())
                .interestRate(loan.getInterestRate())
                .installments(loan.getInstallments())
                .status(loan.getStatus().getName())
                .requestDate(loan.getRequestDate())
                .build();
    }

    public static LoanPaymentDTO toDto(LoanPayment payment) {
        return LoanPaymentDTO.builder()
                .id(payment.getId())
                .loanId(payment.getLoan().getId())
                .amountPaid(payment.getAmountPaid())
                .paymentDate(payment.getPaymentDate())
                .build();
    }
}
