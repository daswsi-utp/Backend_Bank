package com.bank.service_log.service;

import com.bank.service_log.dto.AuditLogRequestDTO;
import com.bank.service_log.dto.AuditLogResponseDTO;

import java.util.List;

public interface AuditLogService {

    AuditLogResponseDTO createLog(AuditLogRequestDTO requestDTO);

    AuditLogResponseDTO getLogById(Long id);

    List<AuditLogResponseDTO> getAllLogs();

    AuditLogResponseDTO updateLog(Long id, AuditLogRequestDTO requestDTO);

    void deleteLog(Long id);
}
