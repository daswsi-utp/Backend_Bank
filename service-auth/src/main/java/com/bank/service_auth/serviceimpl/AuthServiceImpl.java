package com.bank.service_auth.serviceimpl;


import com.bank.service_auth.model.AuthSesion;
import com.bank.service_auth.model.AuthToken;
import com.bank.service_auth.model.AuthUsuario;
import com.bank.service_auth.repository.AuthSesionRepository;
import com.bank.service_auth.repository.AuthTokenRepository;
import com.bank.service_auth.repository.AuthUsuarioRepository;
import com.bank.service_auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthUsuarioRepository usuarioRepository;
    private final AuthTokenRepository tokenRepository;
    private final AuthSesionRepository sesionRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(AuthUsuarioRepository usuarioRepository,
                           AuthTokenRepository tokenRepository,
                           AuthSesionRepository sesionRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.tokenRepository = tokenRepository;
        this.sesionRepository = sesionRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<AuthUsuario> login(String email, String rawPassword) {
        Optional<AuthUsuario> optionalUsuario = usuarioRepository.findByEmail(email);

        if (optionalUsuario.isEmpty()) return Optional.empty();

        AuthUsuario usuario = optionalUsuario.get();

        if (!usuario.getEstaActivo() || Boolean.TRUE.equals(usuario.getCuentaBloqueada())) {
            return Optional.empty(); // usuario bloqueado o inactivo
        }

        boolean passwordCorrecta = passwordEncoder.matches(rawPassword, usuario.getHashContrasena());

        if (!passwordCorrecta) {
            int intentos = usuario.getIntentosFallidos() + 1;
            usuario.setIntentosFallidos(intentos);

            if (intentos >= 5) {
                usuario.setCuentaBloqueada(true);
            }

            usuarioRepository.save(usuario);
            return Optional.empty();
        }

        usuario.setIntentosFallidos(0); // resetear intentos fallidos
        usuarioRepository.save(usuario);

        return Optional.of(usuario);
    }

    @Override
    public AuthToken generarToken(AuthUsuario usuario) {
        String token = UUID.randomUUID().toString();
        String refreshToken = UUID.randomUUID().toString();

        AuthToken authToken = AuthToken.builder()
                .usuario(usuario)
                .token(token)
                .refreshToken(refreshToken)
                .fechaEmision(LocalDateTime.now())
                .estaRevocado(false)
                .build();

        return tokenRepository.save(authToken);
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

        return sesionRepository.save(sesion);
    }

    @Override
    public void revocarToken(String token) {
        tokenRepository.findByToken(token).ifPresent(authToken -> {
            authToken.setEstaRevocado(true);
            tokenRepository.save(authToken);
        });
    }

    @Override
    public void cerrarSesion(Long idSesion) {
        sesionRepository.findById(idSesion).ifPresent(sesion -> {
            sesion.setEstaActiva(false);
            sesion.setCierre(LocalDateTime.now());
            sesionRepository.save(sesion);
        });
    }
}
