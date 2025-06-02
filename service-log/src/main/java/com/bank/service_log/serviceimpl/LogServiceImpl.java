package com.bank.service_log.serviceimpl;

import com.bank.service_log.dto.LogMapper;
import com.bank.service_log.dto.LogRequestDTO;
import com.bank.service_log.dto.LogResponseDTO;
import com.bank.service_log.model.LogEntry;
import com.bank.service_log.repository.LogEntryRepository;
import com.bank.service_log.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements LogService {

    private final LogEntryRepository logRepository;

    @Override
    public LogResponseDTO saveLog(LogRequestDTO dto) {
        LogEntry entity = LogMapper.toEntity(dto);
        LogEntry saved = logRepository.save(entity);
        return LogMapper.toDto(saved);
    }

    @Override
    public Optional<LogResponseDTO> getLogById(Long id) {
        return logRepository.findById(id).map(LogMapper::toDto);
    }

    @Override
    public List<LogResponseDTO> getAllLogs() {
        return logRepository.findAll()
                .stream()
                .map(LogMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<LogResponseDTO> getLogsByUserId(Long userId) {
        return logRepository.findByUserId(userId)
                .stream()
                .map(LogMapper::toDto)
                .collect(Collectors.toList());
    }
}
