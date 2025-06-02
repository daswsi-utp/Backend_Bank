package com.bank.service_auth.controller;

import com.bank.service_auth.dto.AuthRequestDTO;
import com.bank.service_auth.dto.AuthResponseDTO;
import com.bank.service_auth.dto.RefreshTokenDTO;
import com.bank.service_auth.model.AuthUsuario;
import com.bank.service_auth.model.AuthToken;
import com.bank.service_auth.service.AuthService;
import com.bank.service_auth.security.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(AuthService authService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody AuthRequestDTO dto, HttpServletRequest request) {
        AuthUsuario usuario = authService.login(dto.getEmail(), dto.getPassword())
            .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));

        AuthToken token = authService.generarToken(usuario);
        authService.registrarSesion(usuario, request.getRemoteAddr(), request.getHeader("User-Agent"));

        String jwt = jwtUtil.generateToken(usuario.getEmail());

        AuthResponseDTO response = new AuthResponseDTO();
        response.setToken(jwt); // JWT generado
        response.setRefreshToken(token.getRefreshToken());
        response.setRol(usuario.getRol());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            authService.revocarToken(token);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponseDTO> refresh(@Valid @RequestBody RefreshTokenDTO dto) {
        // (por ahora se genera nuevo JWT simulado, puedes mejorarlo con más lógica si deseas)
        return ResponseEntity.status(501).build(); // no implementado aún
    }
}
