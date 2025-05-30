package com.bank.service_transfer.serviceimpl;

import com.bank.service_transfer.dto.TransferRequestDTO;
import com.bank.service_transfer.dto.TransferResponseDTO;
import com.bank.service_transfer.model.Transaction;
import com.bank.service_transfer.repository.TransactionRepository;
import com.bank.service_transfer.service.TransactionService;
import com.bank.service_transfer.service.FeeService;
import com.bank.service_transfer.service.TransferAmountTrackingService;
import com.bank.service_transfer.dto.TransferMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final FeeService feeService;
    private final TransferAmountTrackingService transferAmountTrackingService;

    @Override
    @Transactional
    public TransferResponseDTO createTransfer(TransferRequestDTO transferRequest) {
        // Create and save transaction
        Transaction transaction = TransferMapper.toEntity(transferRequest);
        transaction.setStatus(Transaction.TransactionStatus.PENDING);
        Transaction savedTransaction = transactionRepository.save(transaction);

        // Calculate and create fee if applicable
        var fee = feeService.calculateTransferFee(savedTransaction.getId(), transferRequest.getAmount());

        return TransferMapper.toDto(savedTransaction, fee);
    }

    @Override
    public Optional<TransferResponseDTO> getTransferById(Long id) {
        return transactionRepository.findById(id)
            .map(transaction -> {
                var fee = feeService.getFeesByTransactionId(transaction.getId())
                    .stream()
                    .findFirst()
                    .orElse(null);
                return TransferMapper.toDto(transaction, fee);
            });
    }

    @Override
    public List<TransferResponseDTO> getTransfersBySourceAccount(String accountId) {
        return transactionRepository.findBySourceAccountId(accountId)
            .stream()
            .map(transaction -> TransferMapper.toDto(transaction))
            .collect(Collectors.toList());
    }

    @Override
    public List<TransferResponseDTO> getTransfersByDestinationAccount(String accountId) {
        return transactionRepository.findByDestinationAccountId(accountId)
            .stream()
            .map(transaction -> TransferMapper.toDto(transaction))
            .collect(Collectors.toList());
    }

    @Override
    public BigDecimal getDailyTransferAmount(String accountId, LocalDateTime date) {
        return transferAmountTrackingService.getDailyTransferAmount(accountId, date);
    }

    @Override
    public List<TransferResponseDTO> getTransfersByStatus(Transaction.TransactionStatus status) {
        return transactionRepository.findByStatus(status)
            .stream()
            .map(transaction -> TransferMapper.toDto(transaction))
            .collect(Collectors.toList());
    }

    @Override
    public List<TransferResponseDTO> getTransfersByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByDateBetween(startDate, endDate)
            .stream()
            .map(transaction -> TransferMapper.toDto(transaction))
            .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public TransferResponseDTO updateTransferStatus(Long transferId, Transaction.TransactionStatus newStatus) {
        Transaction transaction = transactionRepository.findById(transferId)
            .orElseThrow(() -> new IllegalArgumentException("Transfer not found with id: " + transferId));
        
        transaction.setStatus(newStatus);
        Transaction updatedTransaction = transactionRepository.save(transaction);
        
        return TransferMapper.toDto(updatedTransaction);
    }

    @Override
    public boolean validateTransferLimit(String accountId, BigDecimal amount) {
        BigDecimal dailyTotal = getDailyTransferAmount(accountId, LocalDateTime.now());
        return dailyTotal.add(amount).compareTo(new BigDecimal("1000000")) <= 0; // Example default limit of 1M
    }

    @Override
    public boolean validateAccountBalance(String accountId, BigDecimal amount) {
        // This would typically integrate with the account service
        // For now, returning true as implementation depends on account service integration
        return true;
    }
}
