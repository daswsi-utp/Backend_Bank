package com.bank.service_card.service;

import com.bank.service_card.dto.CardRequestDTO;
import com.bank.service_card.dto.CardResponseDTO;

import java.util.List;
import java.util.Optional;

public interface CardService {

    CardResponseDTO createCard(CardRequestDTO dto);

    Optional<CardResponseDTO> getCardById(Long id);

    Optional<CardResponseDTO> getCardByNumber(String cardNumber);

    List<CardResponseDTO> getCardsByUserId(Long userId);

    List<CardResponseDTO> getAllCards();
}
