package com.bank.service_account.repository;


import com.bank.service_account.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType, Byte> {
}
