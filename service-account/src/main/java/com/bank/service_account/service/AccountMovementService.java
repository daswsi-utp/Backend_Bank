package com.bank.service_account.service;

import com.bank.service_account.dto.*;

import java.util.List;

public interface AccountMovementService {
    AccountMovementDTO createMovement(CreateAccountMovementDTO dto);
    AccountMovementDTO getMovementById(Long id);
    List<AccountMovementDTO> getMovementsByAccountId(Long accountId);
}
