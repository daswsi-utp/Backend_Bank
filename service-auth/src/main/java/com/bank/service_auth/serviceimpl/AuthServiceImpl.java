package com.bank.service_auth.serviceimpl;

import com.bank.service_auth.model.AuthUsuario;
import com.bank.service_auth.model.AuthToken;
import com.bank.service_auth.model.AuthSesion;
import com.bank.service_auth.repository.AuthUsuarioRepository;
import com.bank.service_auth.repository.AuthTokenRepository;
import com.bank.service_auth.repository.AuthSesionRepository;
import com.bank.service_auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthUsuarioRepository authUsuarioRepository;
    private final AuthTokenRepository authTokenRepository;
    private final AuthSesionRepository authSesionRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Optional<AuthUsuario> login(String email, String rawPassword) {
        return authUsuarioRepository.findByEmail(email)
            .filter(user -> passwordEncoder.matches(rawPassword, user.getHashContrasena()));
    }

    @Override
    public AuthToken generarToken(AuthUsuario usuario) {
        AuthToken token = AuthToken.builder()
                .usuario(usuario)
                .token("GENERATED_JWT") // Aquí luego integras JwtUtil
                .fechaEmision(LocalDateTime.now())
                .expiracion(LocalDateTime.now().plusHours(1))
                .estaRevocado(false)
                .build();
        return authTokenRepository.save(token);
    }

    @Override
    public AuthSesion registrarSesion(AuthUsuario usuario, String ip, String userAgent) {
        AuthSesion sesion = AuthSesion.builder()
                .usuario(usuario)
                .ip(ip)
                .userAgent(userAgent)
                .inicio(LocalDateTime.now())
                .estaActiva(true)
                .build();
        return authSesionRepository.save(sesion);
    }

    @Override
    public void revocarToken(String token) {
        authTokenRepository.findByToken(token).ifPresent(t -> {
            t.setEstaRevocado(true);
            authTokenRepository.save(t);
        });
    }

    @Override
    public void cerrarSesion(Long idSesion) {
        authSesionRepository.findById(idSesion).ifPresent(sesion -> {
            sesion.setEstaActiva(false);
            sesion.setCierre(LocalDateTime.now());
            authSesionRepository.save(sesion);
        });
    }
}
