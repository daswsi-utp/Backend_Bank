package com.bank.service_account.serviceimpl;

import com.bank.service_account.dto.*;
import com.bank.service_account.model.Account;
import com.bank.service_account.model.AccountMovement;
import com.bank.service_account.repository.AccountMovementRepository;
import com.bank.service_account.repository.AccountRepository;
import com.bank.service_account.service.AccountMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountMovementServiceImpl implements AccountMovementService {

    private final AccountMovementRepository movementRepository;
    private final AccountRepository accountRepository;

    @Override
    public AccountMovementDTO createMovement(CreateAccountMovementDTO dto) {
        Account account = accountRepository.findById(dto.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account not found"));

        BigDecimal newBalance = switch (dto.getMovementType()) {
            case DEPOSITO -> account.getBalance().add(dto.getAmount());
            case RETIRO, PAGO, TRANSFERENCIA -> account.getBalance().subtract(dto.getAmount());
        };

        account.setBalance(newBalance);
        account.setAvailableBalance(newBalance);
        accountRepository.save(account);

        AccountMovement movement = AccountMovement.builder()
                .accountId(account.getId())
                .movementType(dto.getMovementType())
                .amount(dto.getAmount())
                .resultingBalance(newBalance)
                .description(dto.getDescription())
                .reference(dto.getReference())
                .date(LocalDateTime.now())
                .build();

        return toDTO(movementRepository.save(movement));
    }

    @Override
    public AccountMovementDTO getMovementById(Long id) {
        return movementRepository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Movement not found"));
    }

    @Override
    public List<AccountMovementDTO> getMovementsByAccountId(Long accountId) {
        return movementRepository.findByAccountIdOrderByDateDesc(accountId)
                .stream().map(this::toDTO)
                .collect(Collectors.toList());
    }

    private AccountMovementDTO toDTO(AccountMovement m) {
        return AccountMovementDTO.builder()
                .id(m.getId())
                .accountId(m.getAccountId())
                .movementType(m.getMovementType())
                .amount(m.getAmount())
                .resultingBalance(m.getResultingBalance())
                .description(m.getDescription())
                .reference(m.getReference())
                .date(m.getDate())
                .build();
    }
}
