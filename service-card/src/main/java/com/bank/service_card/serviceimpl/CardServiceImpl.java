package com.bank.service_card.serviceimpl;

import com.bank.service_card.dto.CardDTO;
import com.bank.service_card.dto.CardRequestDTO;
import com.bank.service_card.model.Card;
import com.bank.service_card.repository.CardRepository;
import com.bank.service_card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public CardDTO createCard(CardRequestDTO request) {
        Card card = Card.builder()
                .userId(request.getUserId())
                .associatedAccountId(request.getAssociatedAccountId())
                .cardNumber(request.getCardNumber())
                .cardTypeId(request.getCardTypeId())
                .cardHolderName(request.getCardHolderName())
                .expirationDate(request.getExpirationDate())
                .cardStatusId(request.getCardStatusId())
                .issueDate(request.getIssueDate())
                .activationDate(request.getActivationDate())
                .build();
        return toDTO(cardRepository.save(card));
    }

    @Override
    public CardDTO getCardById(Long id) {
        return cardRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<CardDTO> getAllCards() {
        return cardRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<CardDTO> getCardsByUserId(Long userId) {
        return cardRepository.findByUserId(userId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public CardDTO updateCard(Long id, CardRequestDTO request) {
        return cardRepository.findById(id).map(card -> {
            card.setUserId(request.getUserId());
            card.setAssociatedAccountId(request.getAssociatedAccountId());
            card.setCardNumber(request.getCardNumber());
            card.setCardTypeId(request.getCardTypeId());
            card.setCardHolderName(request.getCardHolderName());
            card.setExpirationDate(request.getExpirationDate());
            card.setCardStatusId(request.getCardStatusId());
            card.setIssueDate(request.getIssueDate());
            card.setActivationDate(request.getActivationDate());
            return toDTO(cardRepository.save(card));
        }).orElse(null);
    }

    @Override
    public void deleteCard(Long id) {
        cardRepository.deleteById(id);
    }

    private CardDTO toDTO(Card card) {
        return CardDTO.builder()
                .id(card.getId())
                .userId(card.getUserId())
                .associatedAccountId(card.getAssociatedAccountId())
                .cardNumber(card.getCardNumber())
                .maskedNumber(card.getMaskedNumber())
                .cardTypeId(card.getCardTypeId())
                .cardHolderName(card.getCardHolderName())
                .expirationDate(card.getExpirationDate())
                .cardStatusId(card.getCardStatusId())
                .issueDate(card.getIssueDate())
                .activationDate(card.getActivationDate())
                .build();
    }
}
