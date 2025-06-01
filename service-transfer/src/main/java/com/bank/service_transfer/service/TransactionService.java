package com.bank.service_transfer.service;

import com.bank.service_transfer.dto.TransferRequestDTO;
import com.bank.service_transfer.dto.TransferResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionService {

    TransferResponseDTO createTransfer(TransferRequestDTO transferRequest);
    Optional<TransferResponseDTO> getTransferById(Long id);

    List<TransferResponseDTO> getTransfersBySourceAccount(Long sourceAccountId);
    List<TransferResponseDTO> getTransfersByDestinationAccount(Long destinationAccountId);
    List<TransferResponseDTO> getTransfersByDateRange(LocalDateTime start, LocalDateTime end);

    TransferResponseDTO updateTransferStatus(Long transactionId, Byte statusId);

    BigDecimal getDailyTransferAmount(Long accountId, LocalDateTime date);
}
