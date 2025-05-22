package com.bank.service_auth.repository;

import com.bank.service_auth.model.AuthSesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthSesionRepository extends JpaRepository<AuthSesion, Long> {
    List<AuthSesion> findByUsuarioIdUsuario(Long idUsuario);
}
