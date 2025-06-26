package com.bank.serviceuser.dto;

import lombok.Data;

@Data
public class EmpleadoMetadataResponseDTO {

    private Long idEmpleado;

    private String area;

    private String cargo;

    private String fechaIngreso;
}
