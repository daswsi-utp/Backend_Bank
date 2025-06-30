package com.bank.service_fraud.service;

import com.bank.service_fraud.dto.FraudAlertDTO;

import java.util.List;

public interface FraudAlertService {

    List<FraudAlertDTO> getAllAlerts();

    FraudAlertDTO getAlertById(Long id);

    List<FraudAlertDTO> getAlertsByUserId(Long userId);

    List<FraudAlertDTO> getAlertsByTransactionType(String transactionType);

    FraudAlertDTO createAlert(FraudAlertDTO alertDTO);

    FraudAlertDTO updateAlert(Long id, FraudAlertDTO alertDTO);

    void deleteAlert(Long id);
}
