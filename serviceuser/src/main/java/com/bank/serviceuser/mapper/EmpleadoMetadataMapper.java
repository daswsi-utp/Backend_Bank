package com.bank.serviceuser.mapper;

import com.bank.serviceuser.dto.EmpleadoMetadataRequestDTO;
import com.bank.serviceuser.dto.EmpleadoMetadataResponseDTO;
import com.bank.serviceuser.model.EmpleadoMetadata;
import com.bank.serviceuser.model.Usuario;

import java.sql.Date;

public class EmpleadoMetadataMapper {

    public static EmpleadoMetadata toEntity(EmpleadoMetadataRequestDTO dto, Usuario usuario) {
        EmpleadoMetadata metadata = new EmpleadoMetadata();
        metadata.setUsuario(usuario);
        metadata.setArea(dto.getArea());
        metadata.setCargo(dto.getCargo());
        metadata.setFechaIngreso(Date.valueOf(dto.getFechaIngreso()));
        return metadata;
    }

    public static EmpleadoMetadataResponseDTO toDto(EmpleadoMetadata metadata) {
        EmpleadoMetadataResponseDTO dto = new EmpleadoMetadataResponseDTO();
        dto.setIdEmpleado(metadata.getUsuario().getId());
        dto.setArea(metadata.getArea());
        dto.setCargo(metadata.getCargo());
        dto.setFechaIngreso(metadata.getFechaIngreso().toString());
        return dto;
    }
}
