package com.bank.service_card.serviceimpl;


import com.bank.service_card.dto.CardMapper;
import com.bank.service_card.dto.CardRequestDTO;
import com.bank.service_card.dto.CardResponseDTO;
import com.bank.service_card.model.Card;
import com.bank.service_card.repository.CardRepository;
import com.bank.service_card.repository.CardStatusRepository;
import com.bank.service_card.repository.CardTypeRepository;
import com.bank.service_card.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardTypeRepository cardTypeRepository;
    private final CardStatusRepository cardStatusRepository;

    @Override
    public CardResponseDTO createCard(CardRequestDTO dto) {
        Card card = CardMapper.toEntity(dto);
        Card saved = cardRepository.save(card);

        String typeName = cardTypeRepository.findById(dto.getCardTypeId())
                .map(t -> t.getName())
                .orElse("Unknown");

        String statusName = cardStatusRepository.findById(dto.getCardStatusId())
                .map(s -> s.getName())
                .orElse("Unknown");

        return CardMapper.toDto(saved, typeName, statusName);
    }

    @Override
    public Optional<CardResponseDTO> getCardById(Long id) {
        return cardRepository.findById(id).map(card -> {
            String typeName = cardTypeRepository.findById(card.getCardTypeId()).map(t -> t.getName()).orElse("Unknown");
            String statusName = cardStatusRepository.findById(card.getCardStatusId()).map(s -> s.getName()).orElse("Unknown");
            return CardMapper.toDto(card, typeName, statusName);
        });
    }

    @Override
    public Optional<CardResponseDTO> getCardByNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber).map(card -> {
            String typeName = cardTypeRepository.findById(card.getCardTypeId()).map(t -> t.getName()).orElse("Unknown");
            String statusName = cardStatusRepository.findById(card.getCardStatusId()).map(s -> s.getName()).orElse("Unknown");
            return CardMapper.toDto(card, typeName, statusName);
        });
    }

    @Override
    public List<CardResponseDTO> getCardsByUserId(Long userId) {
        return cardRepository.findByUserId(userId).stream()
                .map(card -> {
                    String typeName = cardTypeRepository.findById(card.getCardTypeId()).map(t -> t.getName()).orElse("Unknown");
                    String statusName = cardStatusRepository.findById(card.getCardStatusId()).map(s -> s.getName()).orElse("Unknown");
                    return CardMapper.toDto(card, typeName, statusName);
                }).toList();
    }

    @Override
    public List<CardResponseDTO> getAllCards() {
        return cardRepository.findAll().stream()
                .map(card -> {
                    String typeName = cardTypeRepository.findById(card.getCardTypeId()).map(t -> t.getName()).orElse("Unknown");
                    String statusName = cardStatusRepository.findById(card.getCardStatusId()).map(s -> s.getName()).orElse("Unknown");
                    return CardMapper.toDto(card, typeName, statusName);
                }).toList();
    }
}
