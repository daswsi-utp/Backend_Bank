package com.bank.service_employee.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class EmployeeResponseDTO {

    private Long id;
    private String nombreCompleto;
    private String email;
    private String dni;
    private String telefono;
    private String area;
    private String cargo;
    private LocalDate fechaIngreso;
}
