package com.bank.service_auth.service;

import com.bank.service_auth.model.Credential;
import com.bank.service_auth.model.UserType;

import java.util.Optional;

public interface CredentialService {
    Optional<Credential> findByUserIdAndType(Long userId, UserType userType);
    boolean existsByUserIdAndType(Long userId, UserType userType);
    void updateLoginMetadata(Credential credential);
}
