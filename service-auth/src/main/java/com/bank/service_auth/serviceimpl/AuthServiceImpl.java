package com.bank.service_auth.serviceimpl;

import com.bank.service_auth.dto.LoginRequestDTO;
import com.bank.service_auth.dto.LoginResponseDTO;
import com.bank.service_auth.model.Credential;
import com.bank.service_auth.model.UserType;
import com.bank.service_auth.service.AuthService;
import com.bank.service_auth.service.CredentialService;
import com.bank.service_auth.service.TokenService;
import com.bank.service_auth.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final CredentialService credentialService;
    private final TokenService tokenService;
    private final SessionService sessionService;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        UserType userType = UserType.valueOf(loginRequest.getUserType());
        Optional<Credential> optCred = credentialService.findByUserIdAndType(loginRequest.getUserId(), userType);

        if (optCred.isEmpty()) {
            throw new RuntimeException("Usuario no registrado");
        }

        Credential cred = optCred.get();

        if (!cred.getPasswordHash().equals(loginRequest.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        if (!cred.getIsActive() || cred.getAccountLocked()) {
            throw new RuntimeException("Cuenta inactiva o bloqueada");
        }

        tokenService.revokeAllTokens(cred.getUserId(), cred.getUserType());
        var newToken = tokenService.generateToken(cred.getUserId(), cred.getUserType(), cred.getRole());

        sessionService.registerSession(cred.getUserId(), cred.getUserType(), "127.0.0.1", "Chrome", "PC");

        credentialService.updateLoginMetadata(cred);

        return LoginResponseDTO.builder()
                .token(newToken.getToken())
                .refreshToken(newToken.getRefreshToken())
                .role(cred.getRole())
                .twoFactorEnabled(cred.getTwoFactorEnabled())
                .build();
    }

    @Override
    public void logout(Long userId, String userTypeStr) {
        UserType userType = UserType.valueOf(userTypeStr);
        tokenService.revokeAllTokens(userId, userType);
        sessionService.closeSessions(userId, userType);
    }

    @Override
    public boolean validateToken(String token) {
        // Aquí puede ir lógica real de validación con JWT
        return token != null && !token.isBlank();
    }
}
