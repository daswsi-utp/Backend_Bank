package com.bank.service_auth.serviceimpl;

import com.bank.service_auth.dto.LoginRequestDTO;
import com.bank.service_auth.dto.LoginResponseDTO;
import com.bank.service_auth.model.Credential;
import com.bank.service_auth.repository.CredentialRepository;
import com.bank.service_auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final CredentialRepository credentialRepository;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        Credential credential = credentialRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!credential.getPasswordHash().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return LoginResponseDTO.builder()
                .userId(credential.getUserId())
                .email(credential.getEmail())
                .role(credential.getRole())
                .userType(credential.getUserType().name())
                .build();
    }
}
