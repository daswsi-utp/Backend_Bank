package com.bank.service_fraud.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FraudPatternDTO {
    private Integer id;
    private String name;
    private String description;
    private String rules; // JSON como texto
    private String severity;
    private Boolean isActive;
}
