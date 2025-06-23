package com.bank.service_transfer.serviceimpl;

import com.bank.service_transfer.dto.*;
import com.bank.service_transfer.model.Fee;
import com.bank.service_transfer.model.Transaction;
import com.bank.service_transfer.model.TransferStatus;
import com.bank.service_transfer.repository.TransactionRepository;
import com.bank.service_transfer.service.FeeService;
import com.bank.service_transfer.service.TransactionService;
import com.bank.service_transfer.service.TransferAmountTrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final FeeService feeService;
    private final TransferAmountTrackingService trackingService;

    @Override
    @Transactional
    public TransferResponseDTO createTransfer(TransferRequestDTO request) {
        // Usar enum directamente, 1 = PENDING
        TransferStatus status = TransferStatus.PENDING;

        Transaction transaction = TransferMapper.toEntity(request, status);
        Transaction saved = transactionRepository.save(transaction);

        Fee fee = feeService.calculateTransferFee(saved.getId(), request.getAmount());

        return TransferMapper.toDto(saved, fee);
    }

    @Override
    public Optional<TransferResponseDTO> getTransferById(Long id) {
        return transactionRepository.findById(id)
                .map(tx -> {
                    Fee fee = feeService.getFeesByTransactionId(tx.getId())
                            .stream()
                            .findFirst()
                            .orElse(null);
                    return TransferMapper.toDto(tx, fee);
                });
    }

    @Override
    public List<TransferResponseDTO> getTransfersBySourceAccount(Long accountId) {
        return transactionRepository.findBySourceAccountId(accountId).stream()
                .map(TransferMapper::toDto)
                .toList();
    }

    @Override
    public List<TransferResponseDTO> getTransfersByDestinationAccount(Long accountId) {
        return transactionRepository.findByDestinationAccountId(accountId).stream()
                .map(TransferMapper::toDto)
                .toList();
    }

    @Override
    public List<TransferResponseDTO> getTransfersByDateRange(LocalDateTime start, LocalDateTime end) {
        return transactionRepository.findByDateBetween(start, end).stream()
                .map(TransferMapper::toDto)
                .toList();
    }

    @Override
    public TransferResponseDTO updateTransferStatus(Long transferId, Byte statusId) {
        Transaction tx = transactionRepository.findById(transferId)
                .orElseThrow(() -> new RuntimeException("Transferencia no encontrada"));

        TransferStatus newStatus = TransferStatus.values()[statusId - 1]; // 1 → PENDING, 2 → APPROVED...

        tx.setStatus(newStatus);
        Transaction updated = transactionRepository.save(tx);

        Fee fee = feeService.getFeesByTransactionId(tx.getId()).stream().findFirst().orElse(null);
        return TransferMapper.toDto(updated, fee);
    }

    @Override
    public BigDecimal getDailyTransferAmount(Long accountId, LocalDateTime date) {
        return trackingService.getDailyTransferAmount(accountId, date);
    }
}
