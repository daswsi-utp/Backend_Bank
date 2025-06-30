package com.bank.service_auth.serviceimpl;

import com.bank.service_auth.model.AuthSession;
import com.bank.service_auth.model.UserType;
import com.bank.service_auth.repository.AuthSessionRepository;
import com.bank.service_auth.service.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final AuthSessionRepository repository;

    @Override
    public void registerSession(Long userId, UserType userType, String ip, String userAgent, String device) {
        AuthSession session = AuthSession.builder()
                .userId(userId)
                .userType(userType)
                .ip(ip)
                .userAgent(userAgent)
                .device(device)
                .start(LocalDateTime.now())
                .isActive(true)
                .build();

        repository.save(session);
    }

    @Override
    public void closeSessions(Long userId, UserType userType) {
        List<AuthSession> sessions = repository.findByUserIdAndUserType(userId, userType);
        sessions.forEach(s -> {
            s.setEnd(LocalDateTime.now());
            s.setIsActive(false);
        });
        repository.saveAll(sessions);
    }

    @Override
    public List<AuthSession> getSessionsByUser(Long userId, UserType userType) {
        return repository.findByUserIdAndUserType(userId, userType);
    }
}
