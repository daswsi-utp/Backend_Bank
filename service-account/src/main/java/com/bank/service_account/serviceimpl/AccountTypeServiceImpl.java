package com.bank.service_account.serviceimpl;

import com.bank.service_account.model.AccountType;
import com.bank.service_account.repository.AccountTypeRepository;
import com.bank.service_account.service.AccountTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountTypeServiceImpl implements AccountTypeService {

    private final AccountTypeRepository accountTypeRepository;

    @Override
    public List<AccountType> getAllAccountTypes() {
        return accountTypeRepository.findAll();
    }
}
