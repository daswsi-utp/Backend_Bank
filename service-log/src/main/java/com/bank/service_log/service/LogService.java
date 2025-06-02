package com.bank.service_log.service;

import com.bank.service_log.dto.LogRequestDTO;
import com.bank.service_log.dto.LogResponseDTO;

import java.util.List;
import java.util.Optional;

public interface LogService {
    LogResponseDTO saveLog(LogRequestDTO dto);
    Optional<LogResponseDTO> getLogById(Long id);
    List<LogResponseDTO> getAllLogs();
    List<LogResponseDTO> getLogsByUserId(Long userId);
}
