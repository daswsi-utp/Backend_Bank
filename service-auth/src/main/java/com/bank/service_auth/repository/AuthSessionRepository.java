package com.bank.service_auth.repository;

import com.bank.service_auth.model.AuthSession;
import com.bank.service_auth.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthSessionRepository extends JpaRepository<AuthSession, Long> {
    List<AuthSession> findByUserIdAndIsActiveTrue(Long userId);
    List<AuthSession> findByUserIdAndUserType(Long userId, UserType userType);
}
