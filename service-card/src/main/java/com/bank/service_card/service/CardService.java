package com.bank.service_card.service;

import com.bank.service_card.dto.CardDTO;
import com.bank.service_card.dto.CardRequestDTO;

import java.util.List;

public interface CardService {
    CardDTO createCard(CardRequestDTO request);
    CardDTO getCardById(Long id);
    List<CardDTO> getAllCards();
    List<CardDTO> getCardsByUserId(Long userId);
    CardDTO updateCard(Long id, CardRequestDTO request);
    void deleteCard(Long id);
}
