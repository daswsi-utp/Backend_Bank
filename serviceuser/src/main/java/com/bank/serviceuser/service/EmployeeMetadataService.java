package com.bank.serviceuser.service;

import com.bank.serviceuser.dto.EmpleadoMetadataRequestDTO;
import com.bank.serviceuser.dto.EmpleadoMetadataResponseDTO;

import java.util.Optional;

public interface EmployeeMetadataService {

    EmpleadoMetadataResponseDTO createMetadata(EmpleadoMetadataRequestDTO requestDTO);

    Optional<EmpleadoMetadataResponseDTO> getMetadataById(Long id);

    EmpleadoMetadataResponseDTO updateMetadata(Long id, EmpleadoMetadataRequestDTO requestDTO);

    void deleteMetadata(Long id);
}
