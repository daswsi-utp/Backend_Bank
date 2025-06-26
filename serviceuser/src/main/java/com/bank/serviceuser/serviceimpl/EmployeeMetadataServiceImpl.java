package com.bank.serviceuser.serviceimpl;

import com.bank.serviceuser.dto.EmpleadoMetadataRequestDTO;
import com.bank.serviceuser.dto.EmpleadoMetadataResponseDTO;
import com.bank.serviceuser.mapper.EmpleadoMetadataMapper;
import com.bank.serviceuser.model.EmpleadoMetadata;
import com.bank.serviceuser.model.Usuario;
import com.bank.serviceuser.repository.EmployeeMetadataRepository;
import com.bank.serviceuser.repository.UserRepository;
import com.bank.serviceuser.service.EmployeeMetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeMetadataServiceImpl implements EmployeeMetadataService {

    private final EmployeeMetadataRepository metadataRepository;
    private final UserRepository userRepository;

    @Override
    public EmpleadoMetadataResponseDTO createMetadata(EmpleadoMetadataRequestDTO requestDTO) {
        Usuario user = userRepository.findById(requestDTO.getIdEmpleado())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + requestDTO.getIdEmpleado()));

        EmpleadoMetadata metadata = EmpleadoMetadataMapper.toEntity(requestDTO, user);
        EmpleadoMetadata saved = metadataRepository.save(metadata);
        return EmpleadoMetadataMapper.toDto(saved);
    }

    @Override
    public Optional<EmpleadoMetadataResponseDTO> getMetadataById(Long id) {
        return metadataRepository.findById(id)
                .map(EmpleadoMetadataMapper::toDto);
    }

    @Override
    public EmpleadoMetadataResponseDTO updateMetadata(Long id, EmpleadoMetadataRequestDTO requestDTO) {
        EmpleadoMetadata metadata = metadataRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Metadata no encontrada con ID: " + id));

        metadata.setArea(requestDTO.getArea());
        metadata.setCargo(requestDTO.getCargo());
        metadata.setFechaIngreso(java.sql.Date.valueOf(requestDTO.getFechaIngreso()));

        return EmpleadoMetadataMapper.toDto(metadataRepository.save(metadata));
    }

    @Override
    public void deleteMetadata(Long id) {
        if (!metadataRepository.existsById(id)) {
            throw new RuntimeException("Metadata no encontrada con ID: " + id);
        }
        metadataRepository.deleteById(id);
    }
}
