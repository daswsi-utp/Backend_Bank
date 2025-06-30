package com.bank.service_account.service;

import com.bank.service_account.dto.*;

import java.util.List;

public interface AccountService {
    AccountDTO createAccount(CreateAccountDTO dto);
    AccountDTO updateAccount(Long id, UpdateAccountDTO dto);
    void deleteAccount(Long id);
    AccountDTO getAccountById(Long id);
    List<AccountDTO> getAccountsByUserId(Long userId);
    List<AccountDTO> getAllAccounts();
}
