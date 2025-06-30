package com.bank.service_payment.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDTO {
    private Integer id;
    private String name;
    private String code;
    private Boolean isActive;
}
