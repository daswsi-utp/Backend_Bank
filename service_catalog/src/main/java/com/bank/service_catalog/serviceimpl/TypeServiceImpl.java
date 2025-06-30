package com.bank.service_catalog.serviceimpl;

import com.bank.service_catalog.dto.TypeDTO;
import com.bank.service_catalog.model.Type;
import com.bank.service_catalog.repository.TypeRepository;
import com.bank.service_catalog.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Override
    public List<TypeDTO> getAllTypes() {
        return typeRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TypeDTO getTypeById(Byte id) {
        Type type = typeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Type not found"));
        return toDTO(type);
    }

    @Override
    public TypeDTO createType(TypeDTO dto) {
        if (typeRepository.existsByModuleAndName(dto.getModule(), dto.getName())) {
            throw new RuntimeException("Type already exists for this module and name");
        }
        Type saved = typeRepository.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public TypeDTO updateType(Byte id, TypeDTO dto) {
        Type existing = typeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Type not found"));

        existing.setModule(dto.getModule());
        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setParameters(dto.getParameters());

        return toDTO(typeRepository.save(existing));
    }

    @Override
    public void deleteType(Byte id) {
        if (!typeRepository.existsById(id)) {
            throw new RuntimeException("Type not found");
        }
        typeRepository.deleteById(id);
    }

    private TypeDTO toDTO(Type type) {
        return TypeDTO.builder()
                .id(type.getId())
                .module(type.getModule())
                .name(type.getName())
                .description(type.getDescription())
                .parameters(type.getParameters())
                .build();
    }

    private Type toEntity(TypeDTO dto) {
        return Type.builder()
                .module(dto.getModule())
                .name(dto.getName())
                .description(dto.getDescription())
                .parameters(dto.getParameters())
                .build();
    }
}
