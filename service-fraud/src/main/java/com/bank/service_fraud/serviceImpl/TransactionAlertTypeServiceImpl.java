package com.bank.service_fraud.serviceImpl;

import com.bank.service_fraud.model.TransactionAlertType;
import com.bank.service_fraud.repository.TransactionAlertTypeRepository;
import com.bank.service_fraud.service.TransactionAlertTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionAlertTypeServiceImpl implements TransactionAlertTypeService {

    private final TransactionAlertTypeRepository repository;

    @Override
    public List<TransactionAlertType> getAllTypes() {
        return repository.findAll();
    }
}
