package com.bank.service_account.service;

import com.bank.service_account.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
    Account createAccount(Account account);
    Optional<Account> getAccountById(Long id);
    Optional<Account> getAccountByNumber(String accountNumber);
    List<Account> getAccountsByUserId(Long userId);
    List<Account> getAllAccounts();
}
