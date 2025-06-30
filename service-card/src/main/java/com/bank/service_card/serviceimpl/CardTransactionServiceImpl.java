package com.bank.service_card.serviceimpl;

import com.bank.service_card.dto.CardTransactionDTO;
import com.bank.service_card.dto.CardTransactionRequestDTO;
import com.bank.service_card.model.CardTransaction;
import com.bank.service_card.repository.CardTransactionRepository;
import com.bank.service_card.service.CardTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardTransactionServiceImpl implements CardTransactionService {

    private final CardTransactionRepository transactionRepository;

    @Override
    public CardTransactionDTO createTransaction(CardTransactionRequestDTO request) {
        CardTransaction transaction = CardTransaction.builder()
                .cardId(request.getCardId())
                .amount(request.getAmount())
                .currency(request.getCurrency())
                .merchant(request.getMerchant())
                .location(request.getLocation())
                .authorizationCode(request.getAuthorizationCode())
                .date(new Timestamp(System.currentTimeMillis()))
                .build();
        return toDTO(transactionRepository.save(transaction));
    }

    @Override
    public CardTransactionDTO getTransactionById(Long id) {
        return transactionRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<CardTransactionDTO> getTransactionsByCardId(Long cardId) {
        return transactionRepository.findByCardId(cardId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<CardTransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    private CardTransactionDTO toDTO(CardTransaction tx) {
        return CardTransactionDTO.builder()
                .id(tx.getId())
                .cardId(tx.getCardId())
                .amount(tx.getAmount())
                .currency(tx.getCurrency())
                .merchant(tx.getMerchant())
                .location(tx.getLocation())
                .authorizationCode(tx.getAuthorizationCode())
                .date(tx.getDate())
                .build();
    }
}
