package com.bank.service_log.serviceimpl;

import com.bank.service_log.dto.AuditLogRequestDTO;
import com.bank.service_log.dto.AuditLogResponseDTO;
import com.bank.service_log.model.AuditLog;
import com.bank.service_log.repository.AuditLogRepository;
import com.bank.service_log.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRepository auditLogRepository;

    @Override
    public AuditLogResponseDTO createLog(AuditLogRequestDTO requestDTO) {
        AuditLog log = AuditLog.builder()
                .userId(requestDTO.getUserId())
                .userType(requestDTO.getUserType())
                .action(requestDTO.getAction())
                .affectedEntity(requestDTO.getAffectedEntity())
                .affectedEntityId(requestDTO.getAffectedEntityId())
                .ip(requestDTO.getIp())
                .userAgent(requestDTO.getUserAgent())
                .details(requestDTO.getDetails())
                .date(LocalDateTime.now())
                .build();

        AuditLog saved = auditLogRepository.save(log);
        return toDTO(saved);
    }

    @Override
    public AuditLogResponseDTO getLogById(Long id) {
        AuditLog log = auditLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found with ID: " + id));
        return toDTO(log);
    }

    @Override
    public List<AuditLogResponseDTO> getAllLogs() {
        return auditLogRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuditLogResponseDTO updateLog(Long id, AuditLogRequestDTO requestDTO) {
        AuditLog log = auditLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found with ID: " + id));

        log.setUserId(requestDTO.getUserId());
        log.setUserType(requestDTO.getUserType());
        log.setAction(requestDTO.getAction());
        log.setAffectedEntity(requestDTO.getAffectedEntity());
        log.setAffectedEntityId(requestDTO.getAffectedEntityId());
        log.setIp(requestDTO.getIp());
        log.setUserAgent(requestDTO.getUserAgent());
        log.setDetails(requestDTO.getDetails());
        log.setDate(LocalDateTime.now());

        return toDTO(auditLogRepository.save(log));
    }

    @Override
    public void deleteLog(Long id) {
        if (!auditLogRepository.existsById(id)) {
            throw new RuntimeException("Log not found with ID: " + id);
        }
        auditLogRepository.deleteById(id);
    }

    private AuditLogResponseDTO toDTO(AuditLog log) {
        return AuditLogResponseDTO.builder()
                .id(log.getId())
                .userId(log.getUserId())
                .userType(log.getUserType())
                .action(log.getAction())
                .affectedEntity(log.getAffectedEntity())
                .affectedEntityId(log.getAffectedEntityId())
                .ip(log.getIp())
                .userAgent(log.getUserAgent())
                .details(log.getDetails())
                .date(log.getDate())
                .build();
    }
}
