package com.bank.service_card.repository;

import com.bank.service_card.model.CardStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardStatusRepository extends JpaRepository<CardStatus, Byte> {
}
