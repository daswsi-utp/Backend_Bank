package com.bank.service_card.service;

import com.bank.service_card.dto.CardTransactionDTO;
import com.bank.service_card.dto.CardTransactionRequestDTO;

import java.util.List;

public interface CardTransactionService {
    CardTransactionDTO createTransaction(CardTransactionRequestDTO request);
    CardTransactionDTO getTransactionById(Long id);
    List<CardTransactionDTO> getTransactionsByCardId(Long cardId);
    List<CardTransactionDTO> getAllTransactions();
    void deleteTransaction(Long id);
}
