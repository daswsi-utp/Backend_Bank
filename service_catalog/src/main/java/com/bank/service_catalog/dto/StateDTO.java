package com.bank.service_catalog.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StateDTO {
    private Byte id;
    private String module;
    private String name;
    private String description;
    private Boolean isActive;
}
