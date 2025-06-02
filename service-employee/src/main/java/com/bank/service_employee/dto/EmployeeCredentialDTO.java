package com.bank.service_employee.dto;

import lombok.Data;

@Data
public class EmployeeCredentialDTO {

    private Long id;
    private Long employeeId;
    private String rol;
    private Boolean active;
    private Boolean blocked;
    private Integer failedAttempts;
}
