package com.bank.serviceuser.service;

import com.bank.serviceuser.model.Credencial;

import java.util.Optional;

public interface CredentialService {
    Credencial createCredential(Credencial credencial);
    Optional<Credencial> getCredentialByUserId(Long userId);
}
