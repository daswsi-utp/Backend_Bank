package com.bank.service_card.serviceimpl;


import com.bank.service_card.model.CardStatus;
import com.bank.service_card.repository.CardStatusRepository;
import com.bank.service_card.service.CardStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardStatusServiceImpl implements CardStatusService {

    private final CardStatusRepository repository;

    @Override
    public List<CardStatus> getAllCardStatuses() {
        return repository.findAll();
    }
}
