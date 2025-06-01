package com.bank.service_card.dto;


import com.bank.service_card.model.*;

public class CardMapper {

    public static Card toEntity(CardRequestDTO dto) {
        return Card.builder()
                .userId(dto.getUserId())
                .cardNumber(dto.getCardNumber())
                .cvv(dto.getCvv())
                .cardTypeId(dto.getCardTypeId())
                .expirationDate(dto.getExpirationDate())
                .cardStatusId(dto.getCardStatusId())
                .build();
    }

    public static CardResponseDTO toDto(Card card, String typeName, String statusName) {
        return CardResponseDTO.builder()
                .id(card.getId())
                .userId(card.getUserId())
                .cardNumber(card.getCardNumber())
                .cvv(card.getCvv())
                .expirationDate(card.getExpirationDate())
                .cardTypeName(typeName)
                .cardStatusName(statusName)
                .build();
    }
}
