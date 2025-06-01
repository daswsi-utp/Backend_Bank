package com.bank.service_card.repository;


import com.bank.service_card.model.CardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardTypeRepository extends JpaRepository<CardType, Byte> {
}
