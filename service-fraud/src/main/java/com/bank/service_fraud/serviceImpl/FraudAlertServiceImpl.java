package com.bank.service_fraud.serviceImpl;

import com.bank.service_fraud.dto.*;
import com.bank.service_fraud.model.FraudAlert;
import com.bank.service_fraud.repository.FraudAlertRepository;
import com.bank.service_fraud.service.FraudAlertService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRepository fraudAlertRepository;

    @Override
    @Transactional
    public FraudAlertResponseDTO createAlert(FraudAlertRequestDTO requestDTO) {
        FraudAlert entity = FraudAlertMapper.toEntity(requestDTO);
        FraudAlert saved = fraudAlertRepository.save(entity);
        return FraudAlertMapper.toDto(saved);
    }

    @Override
    public Optional<FraudAlertResponseDTO> getAlertById(Integer id) {
        return fraudAlertRepository.findById(id).map(FraudAlertMapper::toDto);
    }

    @Override
    public List<FraudAlertResponseDTO> getAlertsByUserId(Long userId) {
        return fraudAlertRepository.findByUserId(userId)
                .stream().map(FraudAlertMapper::toDto).toList();
    }

    @Override
    public List<FraudAlertResponseDTO> getAllAlerts() {
        return fraudAlertRepository.findAll()
                .stream().map(FraudAlertMapper::toDto).toList();
    }

    @Override
    @Transactional
    public FraudAlertResponseDTO confirmAlert(Integer id) {
        FraudAlert alert = fraudAlertRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fraud alert not found with id: " + id));

        alert.setConfirmed(true);
        return FraudAlertMapper.toDto(fraudAlertRepository.save(alert));
    }
}
