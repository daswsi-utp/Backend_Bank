package com.bank.serviceuser.serviceimpl;

import com.bank.serviceuser.model.Credencial;
import com.bank.serviceuser.repository.CredentialRepository;
import com.bank.serviceuser.service.CredentialService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CredentialServiceImpl implements CredentialService {

    private final CredentialRepository credentialRepository;

    @Autowired
    public CredentialServiceImpl(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    @Override
    public Credencial createCredential(Credencial credencial) {
        return credentialRepository.save(credencial);
    }

    @Override
    public Optional<Credencial> getCredentialByUserId(Long userId) {
        return credentialRepository.findByUsuarioId(userId);
    }

    @Override
    public Optional<Credencial> getCredentialByEmail(String email) {
        return credentialRepository.findByUsuarioEmail(email);
    }
}
