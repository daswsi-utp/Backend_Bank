package com.bank.serviceuser.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmpleadoMetadataRequestDTO {

    @NotNull
    private Long idEmpleado; // ID del usuario ya creado

    @NotBlank
    private String area;

    @NotBlank
    private String cargo;

    @NotBlank
    private String fechaIngreso; // Formato: "YYYY-MM-DD"
}
