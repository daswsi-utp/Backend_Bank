package com.bank.service_auth.repository;

import com.bank.service_auth.model.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {
    List<AuthToken> findByUsuarioIdUsuario(Long idUsuario);
    Optional<AuthToken> findByToken(String token);
}

