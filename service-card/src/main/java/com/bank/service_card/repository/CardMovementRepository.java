package com.bank.service_card.repository;


import com.bank.service_card.model.CardMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardMovementRepository extends JpaRepository<CardMovement, Long> {
    List<CardMovement> findByCardId(Long cardId);
}
