package com.bank.service_auth.repository;

import com.bank.service_auth.model.AuthUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthUsuarioRepository extends JpaRepository<AuthUsuario, Long> {
    Optional<AuthUsuario> findByEmail(String email);
}

