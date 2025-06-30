package com.bank.service_fraud.serviceImpl;

import com.bank.service_fraud.dto.FraudAlertDTO;
import com.bank.service_fraud.model.FraudAlert;
import com.bank.service_fraud.model.TransactionType;
import com.bank.service_fraud.repository.FraudAlertRepository;
import com.bank.service_fraud.service.FraudAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FraudAlertServiceImpl implements FraudAlertService {

    private final FraudAlertRepository alertRepository;

    @Override
    public List<FraudAlertDTO> getAllAlerts() {
        return alertRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public FraudAlertDTO getAlertById(Long id) {
        return alertRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<FraudAlertDTO> getAlertsByUserId(Long userId) {
        return alertRepository.findByUserId(userId).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<FraudAlertDTO> getAlertsByTransactionType(String transactionType) {
        TransactionType type = TransactionType.valueOf(transactionType.toUpperCase());
        return alertRepository.findByTransactionType(type).stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public FraudAlertDTO createAlert(FraudAlertDTO dto) {
        FraudAlert entity = toEntity(dto);
        return toDTO(alertRepository.save(entity));
    }

    @Override
    public FraudAlertDTO updateAlert(Long id, FraudAlertDTO dto) {
        Optional<FraudAlert> optional = alertRepository.findById(id);
        if (optional.isPresent()) {
            FraudAlert entity = toEntity(dto);
            entity.setId(id);
            return toDTO(alertRepository.save(entity));
        }
        return null;
    }

    @Override
    public void deleteAlert(Long id) {
        alertRepository.deleteById(id);
    }

    // ---------------------
    private FraudAlertDTO toDTO(FraudAlert entity) {
        return FraudAlertDTO.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .transactionType(entity.getTransactionType().name())
                .transactionId(entity.getTransactionId())
                .riskScore(entity.getRiskScore())
                .reason(entity.getReason())
                .actionTaken(entity.getActionTaken())
                .date(entity.getDate())
                .build();
    }

    private FraudAlert toEntity(FraudAlertDTO dto) {
        return FraudAlert.builder()
                .userId(dto.getUserId())
                .transactionType(TransactionType.valueOf(dto.getTransactionType().toUpperCase()))
                .transactionId(dto.getTransactionId())
                .riskScore(dto.getRiskScore())
                .reason(dto.getReason())
                .actionTaken(dto.getActionTaken())
                .date(dto.getDate())
                .build();
    }
}
