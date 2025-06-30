package com.bank.service_auth.repository;


import com.bank.service_auth.model.AuthToken;
import com.bank.service_auth.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.time.LocalDateTime;


public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {
    List<AuthToken> findByUserIdAndUserType(Long userId, UserType userType);
    List<AuthToken> findByIsRevokedFalseAndExpirationAfter(LocalDateTime now);
}
