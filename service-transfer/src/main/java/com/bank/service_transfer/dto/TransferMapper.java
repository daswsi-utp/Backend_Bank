package com.bank.service_transfer.dto;

import com.bank.service_transfer.model.Transaction;
import com.bank.service_transfer.model.Fee;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

/**
 * Mapper class to convert between DTOs and entities
 */
@Component
public class TransferMapper {
    
    /**
     * Convert TransferRequestDTO to Transaction entity
     */
    public static Transaction toEntity(TransferRequestDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setSourceAccountId(dto.getSourceAccountId());
        transaction.setDestinationAccountId(dto.getDestinationAccountId());
        transaction.setAmount(dto.getAmount());
        transaction.setReference(dto.getReference());
        return transaction;
    }

    /**
     * Convert Transaction and Fee entities to TransferResponseDTO
     */
    public static TransferResponseDTO toDto(Transaction transaction, Fee fee) {
        return TransferResponseDTO.builder()
                .transactionId(transaction.getId())
                .sourceAccountId(transaction.getSourceAccountId())
                .destinationAccountId(transaction.getDestinationAccountId())
                .amount(transaction.getAmount())
                .date(transaction.getDate())
                .status(transaction.getStatus())
                .reference(transaction.getReference())
                .fee(fee != null ? fee.getAmount() : BigDecimal.ZERO)
                .build();
    }

    /**
     * Convert Transaction to TransferResponseDTO without fee information
     */
    public static TransferResponseDTO toDto(Transaction transaction) {
        return toDto(transaction, null);
    }
}
