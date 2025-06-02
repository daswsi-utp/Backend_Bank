package com.bank.service_account.serviceimpl;

import com.bank.service_account.model.AccountStatus;
import com.bank.service_account.repository.AccountStatusRepository;
import com.bank.service_account.service.AccountStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountStatusServiceImpl implements AccountStatusService {

    private final AccountStatusRepository accountStatusRepository;

    @Override
    public List<AccountStatus> getAllAccountStatuses() {
        return accountStatusRepository.findAll();
    }
}
