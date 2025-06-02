package com.bank.service_card.service;

import com.bank.service_card.dto.CardMovementRequestDTO;
import com.bank.service_card.dto.CardMovementResponseDTO;

import java.util.List;

public interface CardMovementService {

    CardMovementResponseDTO registerMovement(CardMovementRequestDTO dto);

    List<CardMovementResponseDTO> getMovementsByCardId(Long cardId);
}
