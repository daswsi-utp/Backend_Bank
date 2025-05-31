package com.bank.service_transfer.service;

import com.bank.service_transfer.dto.TransferRequestDTO;
import com.bank.service_transfer.dto.TransferResponseDTO;
import com.bank.service_transfer.model.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for handling transfer transactions
 */
public interface TransactionService {
    // Core transfer operations
    TransferResponseDTO createTransfer(TransferRequestDTO transferRequest);
    Optional<TransferResponseDTO> getTransferById(Long id);
    
    // Account specific operations
    List<TransferResponseDTO> getTransfersBySourceAccount(String accountId);
    List<TransferResponseDTO> getTransfersByDestinationAccount(String accountId);
    BigDecimal getDailyTransferAmount(String accountId, LocalDateTime date);
    
    // Status and date based queries
    List<TransferResponseDTO> getTransfersByStatus(Transaction.TransactionStatus status);
    List<TransferResponseDTO> getTransfersByDateRange(LocalDateTime startDate, LocalDateTime endDate);
    
    // Update operations
    TransferResponseDTO updateTransferStatus(Long transferId, Transaction.TransactionStatus newStatus);
    
    // Validation methods
    boolean validateTransferLimit(String accountId, BigDecimal amount);
    boolean validateAccountBalance(String accountId, BigDecimal amount);
}
