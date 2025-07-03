package com.bank.service_account.serviceimpl;

import com.bank.service_account.dto.*;
import com.bank.service_account.model.Account;
import com.bank.service_account.repository.AccountRepository;
import com.bank.service_account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

   @Override
public AccountDTO createAccount(CreateAccountDTO dto) {
    Account account = Account.builder()
            .userId(dto.getUserId())
            .accountNumber(dto.getAccountNumber())
            .accountTypeId(dto.getAccountTypeId())
            .balance(dto.getBalance())
            .availableBalance(dto.getAvailableBalance())
            .accountStatusId((byte) 1) // Estado activo por defecto
            .creationDate(LocalDateTime.now())
            .lastUpdate(LocalDateTime.now())
            .build();
    return toDTO(accountRepository.save(account));
}


    @Override
    public AccountDTO updateAccount(Long id, UpdateAccountDTO dto) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(dto.getBalance());
        account.setAvailableBalance(dto.getAvailableBalance());
        account.setAccountStatusId(dto.getAccountStatusId());
        return toDTO(accountRepository.save(account));
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public AccountDTO getAccountById(Long id) {
        return accountRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public List<AccountDTO> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId)
                .stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll()
                .stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    private AccountDTO toDTO(Account account) {
        return AccountDTO.builder()
                .id(account.getId())
                .userId(account.getUserId())
                .accountNumber(account.getAccountNumber())
                .accountTypeId(account.getAccountTypeId())
                .balance(account.getBalance())
                .availableBalance(account.getAvailableBalance())
                .accountStatusId(account.getAccountStatusId())
                .creationDate(account.getCreationDate())
                .lastUpdate(account.getLastUpdate())
                .build();
    }
}
