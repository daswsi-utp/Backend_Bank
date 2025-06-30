package com.bank.service_auth.serviceimpl;

import com.bank.service_auth.model.AuthToken;
import com.bank.service_auth.model.UserType;
import com.bank.service_auth.repository.AuthTokenRepository;
import com.bank.service_auth.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final AuthTokenRepository repository;

    @Override
    public AuthToken generateToken(Long userId, UserType userType, String role) {
        AuthToken token = AuthToken.builder()
                .userId(userId)
                .userType(userType)
                .token(UUID.randomUUID().toString())
                .refreshToken(UUID.randomUUID().toString())
                .issuedAt(LocalDateTime.now())
                .expiration(LocalDateTime.now().plusHours(2))
                .isRevoked(false)
                .build();

        return repository.save(token);
    }

    @Override
    public List<AuthToken> findValidTokens(Long userId, UserType userType) {
        return repository.findByIsRevokedFalseAndExpirationAfter(LocalDateTime.now());
    }

    @Override
    public void revokeAllTokens(Long userId, UserType userType) {
        List<AuthToken> tokens = repository.findByUserIdAndUserType(userId, userType);
        tokens.forEach(t -> t.setIsRevoked(true));
        repository.saveAll(tokens);
    }
}
