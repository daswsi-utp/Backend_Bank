package com.bank.service_auth.controller;

import com.bank.service_auth.dto.LoginRequest;
import com.bank.service_auth.dto.LoginResponse;
import com.bank.service_auth.dto.UsuarioDTO;
import com.bank.service_auth.model.AuthUsuario;
import com.bank.service_auth.security.JwtUtil;
import com.bank.service_auth.service.AuthService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request,
                                   @RequestHeader("User-Agent") String userAgent,
                                   @RequestHeader("X-Forwarded-For") String ip) {

        return authService.login(request.getEmail(), request.getPassword())
                .<ResponseEntity<?>>map(usuario -> {
                    String token = jwtUtil.generateToken(usuario.getEmail());
                    authService.registrarSesion(usuario, ip, userAgent);
                    return ResponseEntity.ok(new LoginResponse(token, "REFRESH_TOKEN"));
                })
                .orElseGet(() -> ResponseEntity.status(401).body("Credenciales inválidas"));
    }

    // NUEVO ENDPOINT: Registro de usuario
    @PostMapping("/register")
    public ResponseEntity<AuthUsuario> registerUser(
            @RequestBody RegisterRequest request
    ) {
        AuthUsuario nuevoUsuario = authService.registrarUsuario(request.getUsuarioDTO(), request.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    // Clase interna para encapsular la solicitud de registro
    @Data
    public static class RegisterRequest {
        private UsuarioDTO usuarioDTO;
        private String password;
    }
}
