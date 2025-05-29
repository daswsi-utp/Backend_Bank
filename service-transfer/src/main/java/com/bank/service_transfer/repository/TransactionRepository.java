package com.bank.service_transfer.repository;

import com.bank.service_transfer.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository interface for Transaction entity operations
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Find transactions by source account
    List<Transaction> findBySourceAccountId(String sourceAccountId);
    
    // Find transactions by destination account
    List<Transaction> findByDestinationAccountId(String destinationAccountId);
    
    // Find transactions by status
    List<Transaction> findByStatus(Transaction.TransactionStatus status);
    
    // Find transactions by date range
    List<Transaction> findByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
    
    // Find transactions by source account and date range
    List<Transaction> findBySourceAccountIdAndDateBetween(
        String sourceAccountId, 
        LocalDateTime startDate, 
        LocalDateTime endDate
    );
}
