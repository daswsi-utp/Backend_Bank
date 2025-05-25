package com.bank.service_account.repository;

import com.bank.service_account.model.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStatusRepository extends JpaRepository<AccountStatus, Byte> {
}
