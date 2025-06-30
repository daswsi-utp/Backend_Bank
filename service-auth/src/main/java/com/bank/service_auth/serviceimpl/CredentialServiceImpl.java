package com.bank.service_auth.serviceimpl;

import com.bank.service_auth.model.Credential;
import com.bank.service_auth.model.UserType;
import com.bank.service_auth.repository.CredentialRepository;
import com.bank.service_auth.service.CredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CredentialServiceImpl implements CredentialService {

    private final CredentialRepository repository;

    @Override
    public Optional<Credential> findByUserIdAndType(Long userId, UserType userType) {
        return repository.findByUserIdAndUserType(userId, userType);
    }

    @Override
    public boolean existsByUserIdAndType(Long userId, UserType userType) {
        return repository.existsByUserIdAndUserType(userId, userType);
    }

    @Override
    public void updateLoginMetadata(Credential credential) {
        credential.setLastLogin(LocalDateTime.now());
        repository.save(credential);
    }
}
