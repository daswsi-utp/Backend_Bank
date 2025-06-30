package com.bank.service_fraud.serviceImpl;

import com.bank.service_fraud.dto.FraudPatternDTO;
import com.bank.service_fraud.model.FraudPattern;
import com.bank.service_fraud.model.Severity;
import com.bank.service_fraud.repository.FraudPatternRepository;
import com.bank.service_fraud.service.FraudPatternService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FraudPatternServiceImpl implements FraudPatternService {

    private final FraudPatternRepository patternRepository;

    @Override
    public List<FraudPatternDTO> getAllPatterns() {
        return patternRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public FraudPatternDTO getPatternById(Integer id) {
        return patternRepository.findById(id).map(this::toDTO).orElse(null);
    }

    @Override
    public List<FraudPatternDTO> getActivePatterns() {
        return patternRepository.findByIsActiveTrue().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public FraudPatternDTO createPattern(FraudPatternDTO dto) {
        FraudPattern entity = toEntity(dto);
        return toDTO(patternRepository.save(entity));
    }

    @Override
    public FraudPatternDTO updatePattern(Integer id, FraudPatternDTO dto) {
        Optional<FraudPattern> optional = patternRepository.findById(id);
        if (optional.isPresent()) {
            FraudPattern entity = toEntity(dto);
            entity.setId(id);
            return toDTO(patternRepository.save(entity));
        }
        return null;
    }

    @Override
    public void deletePattern(Integer id) {
        patternRepository.deleteById(id);
    }

    // ---------------------
    private FraudPatternDTO toDTO(FraudPattern entity) {
        return FraudPatternDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .rules(entity.getRules())
                .severity(entity.getSeverity().name())
                .isActive(entity.getIsActive())
                .build();
    }

    private FraudPattern toEntity(FraudPatternDTO dto) {
        return FraudPattern.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .rules(dto.getRules())
                .severity(Severity.valueOf(dto.getSeverity().toUpperCase()))
                .isActive(dto.getIsActive())
                .build();
    }
}
