package com.bank.service_fraud.service;

import com.bank.service_fraud.dto.FraudAlertRequestDTO;
import com.bank.service_fraud.dto.FraudAlertResponseDTO;

import java.util.List;
import java.util.Optional;

public interface FraudAlertService {
    FraudAlertResponseDTO createAlert(FraudAlertRequestDTO requestDTO);
    Optional<FraudAlertResponseDTO> getAlertById(Integer id);
    List<FraudAlertResponseDTO> getAlertsByUserId(Long userId);
    List<FraudAlertResponseDTO> getAllAlerts();
    FraudAlertResponseDTO confirmAlert(Integer id);
}
