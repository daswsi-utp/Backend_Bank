package com.bank.service_log.dto;

import com.bank.service_log.model.UserType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLogResponseDTO {
    private Long id;
    private Long userId;
    private UserType userType;
    private String action;
    private String affectedEntity;
    private Long affectedEntityId;
    private String ip;
    private String userAgent;
    private String details;
    private LocalDateTime date;
}
