package com.bank.service_employee.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeRequestDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String dni;

    private String telefono;
    private String area;
    private String cargo;

    @NotNull
    private LocalDate fechaIngreso;
}
