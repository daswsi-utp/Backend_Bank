package com.bank.service_card.serviceimpl;


import com.bank.service_card.model.CardType;
import com.bank.service_card.repository.CardTypeRepository;
import com.bank.service_card.service.CardTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardTypeServiceImpl implements CardTypeService {

    private final CardTypeRepository repository;

    @Override
    public List<CardType> getAllCardTypes() {
        return repository.findAll();
    }
}
