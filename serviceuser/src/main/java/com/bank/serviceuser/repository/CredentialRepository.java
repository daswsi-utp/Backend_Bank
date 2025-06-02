package com.bank.serviceuser.repository;

import com.bank.serviceuser.model.Credencial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credencial, Long> {
    Optional<Credencial> findByUsuarioId(Long id); 
    Optional<Credencial> findByUsuarioEmail(String email); // Para login
}
