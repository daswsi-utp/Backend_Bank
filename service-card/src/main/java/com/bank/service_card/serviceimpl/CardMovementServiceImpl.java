package com.bank.service_card.serviceimpl;


import com.bank.service_card.dto.CardMovementRequestDTO;
import com.bank.service_card.dto.CardMovementResponseDTO;
import com.bank.service_card.model.CardMovement;
import com.bank.service_card.repository.CardMovementRepository;
import com.bank.service_card.service.CardMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardMovementServiceImpl implements CardMovementService {

    private final CardMovementRepository movementRepository;

    @Override
    public CardMovementResponseDTO registerMovement(CardMovementRequestDTO dto) {
        CardMovement movement = CardMovement.builder()
                .cardId(dto.getCardId())
                .amount(dto.getAmount())
                .merchant(dto.getMerchant())
                .location(dto.getLocation())
                .date(LocalDateTime.now())
                .build();

        CardMovement saved = movementRepository.save(movement);

        return CardMovementResponseDTO.builder()
                .id(saved.getId())
                .cardId(saved.getCardId())
                .amount(saved.getAmount())
                .merchant(saved.getMerchant())
                .location(saved.getLocation())
                .date(saved.getDate())
                .build();
    }

    @Override
    public List<CardMovementResponseDTO> getMovementsByCardId(Long cardId) {
        return movementRepository.findByCardId(cardId).stream()
                .map(m -> CardMovementResponseDTO.builder()
                        .id(m.getId())
                        .cardId(m.getCardId())
                        .amount(m.getAmount())
                        .merchant(m.getMerchant())
                        .location(m.getLocation())
                        .date(m.getDate())
                        .build())
                .toList();
    }
}
