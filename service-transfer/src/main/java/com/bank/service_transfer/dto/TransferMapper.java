package com.bank.service_transfer.dto;

import com.bank.service_transfer.model.Fee;
import com.bank.service_transfer.model.Transaction;
import com.bank.service_transfer.model.TransferStatus;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class TransferMapper {

    public static Transaction toEntity(TransferRequestDTO dto, TransferStatus status) {
        return Transaction.builder()
                .sourceAccountId(dto.getSourceAccountId())
                .destinationAccountId(dto.getDestinationAccountId())
                .amount(dto.getAmount())
                .reference(dto.getReference())
                .status(status)
                .build();
    }

    public static TransferResponseDTO toDto(Transaction transaction, Fee fee) {
        return TransferResponseDTO.builder()
                .transactionId(transaction.getId())
                .sourceAccountId(transaction.getSourceAccountId())
                .destinationAccountId(transaction.getDestinationAccountId())
                .amount(transaction.getAmount())
                .date(transaction.getDate())
                .statusName(transaction.getStatus().getName())
                .reference(transaction.getReference())
                .fee(fee != null ? fee.getAmount() : BigDecimal.ZERO)
                .build();
    }

    public static TransferResponseDTO toDto(Transaction transaction) {
        return toDto(transaction, null);
    }
}
