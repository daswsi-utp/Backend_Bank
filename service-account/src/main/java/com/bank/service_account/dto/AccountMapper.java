package com.bank.service_account.dto;

import com.bank.service_account.model.*;

public class AccountMapper {

    public static Account toEntity(AccountRequestDTO dto) {
        return Account.builder()
                .userId(dto.getUserId())
                .accountNumber(dto.getAccountNumber())
                .balance(dto.getBalance())
                .accountType(AccountType.builder().id(dto.getAccountTypeId()).build())
                .accountStatus(AccountStatus.builder().id(dto.getAccountStatusId()).build())
                .build();
    }

    public static AccountResponseDTO toDto(Account account) {
    return AccountResponseDTO.builder()
            .id(account.getId())
            .userId(account.getUserId())
            .accountNumber(account.getAccountNumber())
            .balance(account.getBalance())
            .accountTypeName(account.getAccountType() != null ? account.getAccountType().getName() : "Desconocido")
            .accountStatusName(account.getAccountStatus() != null ? account.getAccountStatus().getName() : "Desconocido")
            .createdAt(account.getCreatedAt())
            .build();
}

}
