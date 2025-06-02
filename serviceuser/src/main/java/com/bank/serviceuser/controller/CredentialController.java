package com.bank.serviceuser.controller;

import com.bank.serviceuser.model.Credencial;
import com.bank.serviceuser.service.CredentialService;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/credentials")
@RequiredArgsConstructor
public class CredentialController {

    private final CredentialService credentialService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody LoginRequest request) {
        return credentialService.getCredentialByEmail(request.getEmail())
                .filter(c -> c.getPasswordHash().equals(request.getPassword()))
                .map(credencial -> {
                    Map<String, Object> response = new HashMap<>();
                    response.put("mensaje", "Login exitoso");
                    response.put("usuarioId", credencial.getUsuario().getId());
                    response.put("email", credencial.getUsuario().getEmail());
                    response.put("nombre", credencial.getUsuario().getNombre());
                    response.put("rol", "CLIENTE"); // predeterminado si no hay rol
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> {
                    Map<String, Object> error = new HashMap<>();
                    error.put("mensaje", "Credenciales inválidas");
                    return ResponseEntity.status(401).body(error);
                });
    }

    @Data
    public static class LoginRequest {
        @NotBlank
        private String email;

        @NotBlank
        private String password;
    }
}
