package com.bank.service_auth.service;

import com.bank.service_auth.model.AuthUsuario;
import com.bank.service_auth.model.AuthToken;
import com.bank.service_auth.model.AuthSesion;

import java.util.Optional;

public interface AuthService {
    Optional<AuthUsuario> login(String email, String rawPassword);
    AuthToken generarToken(AuthUsuario usuario);
    AuthSesion registrarSesion(AuthUsuario usuario, String ip, String userAgent);
    void revocarToken(String token);
    void cerrarSesion(Long idSesion);
}
