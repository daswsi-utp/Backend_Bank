package com.bank.service_catalog.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeDTO {
    private Byte id;
    private String module;
    private String name;
    private String description;
    private String parameters; // También puede ser Map<String, Object> si luego quieres deserializarlo
}
