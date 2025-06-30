package com.bank.service_auth.service;

import com.bank.service_auth.model.AuthSession;
import com.bank.service_auth.model.UserType;

import java.util.List;

public interface SessionService {
    void registerSession(Long userId, UserType userType, String ip, String userAgent, String device);
    void closeSessions(Long userId, UserType userType);
    List<AuthSession> getSessionsByUser(Long userId, UserType userType);
}
