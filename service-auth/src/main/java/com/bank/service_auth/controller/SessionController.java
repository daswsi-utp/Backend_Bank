package com.bank.service_auth.controller;

import com.bank.service_auth.model.AuthSession;
import com.bank.service_auth.model.UserType;
import com.bank.service_auth.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AuthSession>> getSessionsByUser(
            @PathVariable Long userId,
            @RequestParam String userType) {

        List<AuthSession> sessions = sessionService.getSessionsByUser(userId, UserType.valueOf(userType));
        return ResponseEntity.ok(sessions);
    }

    @PostMapping("/close")
    public ResponseEntity<String> closeUserSessions(
            @RequestParam Long userId,
            @RequestParam String userType) {

        sessionService.closeSessions(userId, UserType.valueOf(userType));
        return ResponseEntity.ok("Sesiones cerradas correctamente.");
    }
}
