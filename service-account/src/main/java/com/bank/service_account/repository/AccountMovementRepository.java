package com.bank.service_account.repository;

import com.bank.service_account.model.AccountMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountMovementRepository extends JpaRepository<AccountMovement, Long> {

    List<AccountMovement> findByAccountIdOrderByDateDesc(Long accountId);
}
