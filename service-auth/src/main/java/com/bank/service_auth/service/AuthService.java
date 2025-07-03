package com.bank.service_auth.service;

import com.bank.service_auth.dto.LoginRequestDTO;
import com.bank.service_auth.dto.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO loginRequest);
}
