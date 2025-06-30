package com.bank.service_catalog.serviceimpl;

import com.bank.service_catalog.dto.StateDTO;
import com.bank.service_catalog.model.State;
import com.bank.service_catalog.repository.StateRepository;
import com.bank.service_catalog.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    @Override
    public List<StateDTO> getAllStates() {
        return stateRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StateDTO getStateById(Byte id) {
        State state = stateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("State not found"));
        return toDTO(state);
    }

    @Override
    public StateDTO createState(StateDTO dto) {
        if (stateRepository.existsByModuleAndName(dto.getModule(), dto.getName())) {
            throw new RuntimeException("State already exists for this module and name");
        }
        State saved = stateRepository.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public StateDTO updateState(Byte id, StateDTO dto) {
        State existing = stateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("State not found"));

        existing.setModule(dto.getModule());
        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setIsActive(dto.getIsActive());

        return toDTO(stateRepository.save(existing));
    }

    @Override
    public void deleteState(Byte id) {
        if (!stateRepository.existsById(id)) {
            throw new RuntimeException("State not found");
        }
        stateRepository.deleteById(id);
    }

    private StateDTO toDTO(State state) {
        return StateDTO.builder()
                .id(state.getId())
                .module(state.getModule())
                .name(state.getName())
                .description(state.getDescription())
                .isActive(state.getIsActive())
                .build();
    }

    private State toEntity(StateDTO dto) {
        return State.builder()
                .module(dto.getModule())
                .name(dto.getName())
                .description(dto.getDescription())
                .isActive(dto.getIsActive() != null ? dto.getIsActive() : true)
                .build();
    }
}
