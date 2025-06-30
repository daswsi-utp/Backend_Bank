package com.bank.service_auth.repository;


import com.bank.service_auth.model.Credential;
import com.bank.service_auth.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, Long> {
    Optional<Credential> findByUserIdAndUserType(Long userId, UserType userType);
    boolean existsByUserIdAndUserType(Long userId, UserType userType);
}
