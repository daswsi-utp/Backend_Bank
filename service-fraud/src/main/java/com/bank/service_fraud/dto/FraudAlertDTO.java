package com.bank.service_fraud.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudAlertDTO {
    private Long id;
    private Long userId;
    private String transactionType;
    private Long transactionId;
    private Double riskScore;
    private String reason;
    private String actionTaken;
    private Timestamp date;
}
