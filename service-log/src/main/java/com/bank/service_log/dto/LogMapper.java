package com.bank.service_log.dto;

import com.bank.service_log.model.LogEntry;

public class LogMapper {

    public static LogEntry toEntity(LogRequestDTO dto) {
        return LogEntry.builder()
                .userId(dto.getUserId())
                .ip(dto.getIp())
                .navegador(dto.getNavegador())
                .activityType(dto.getActivityType())
                .build();
    }

    public static LogResponseDTO toDto(LogEntry entity) {
        return LogResponseDTO.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .ip(entity.getIp())
                .navegador(entity.getNavegador())
                .activityType(entity.getActivityType())
                .fecha(entity.getFecha())
                .build();
    }
}
