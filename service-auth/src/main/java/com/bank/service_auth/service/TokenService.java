package com.bank.service_auth.service;

import com.bank.service_auth.model.AuthToken;
import com.bank.service_auth.model.UserType;

import java.util.List;

public interface TokenService {
    AuthToken generateToken(Long userId, UserType userType, String role);
    List<AuthToken> findValidTokens(Long userId, UserType userType);
    void revokeAllTokens(Long userId, UserType userType);
}
