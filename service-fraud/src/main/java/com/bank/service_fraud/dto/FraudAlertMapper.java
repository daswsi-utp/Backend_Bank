package com.bank.service_fraud.dto;

import com.bank.service_fraud.model.*;

public class FraudAlertMapper {

    public static FraudAlert toEntity(FraudAlertRequestDTO dto) {
        return FraudAlert.builder()
                .userId(dto.getUserId())
                .transactionType(TransactionAlertType.builder().id(dto.getTransactionTypeId()).build())
                .transactionId(dto.getTransactionId())
                .riskScore(dto.getRiskScore())
                .reason(dto.getReason())
                .confirmed(false)
                .build();
    }

    public static FraudAlertResponseDTO toDto(FraudAlert alert) {
        return FraudAlertResponseDTO.builder()
                .id(alert.getId())
                .userId(alert.getUserId())
                .transactionTypeName(alert.getTransactionType().getName())
                .transactionId(alert.getTransactionId())
                .riskScore(alert.getRiskScore())
                .reason(alert.getReason())
                .fecha(alert.getFecha())
                .confirmed(alert.getConfirmed())
                .build();
    }
}
