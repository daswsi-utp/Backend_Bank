package com.bank.service_catalog.service;

import com.bank.service_catalog.dto.StateDTO;

import java.util.List;

public interface StateService {
    List<StateDTO> getAllStates();
    StateDTO getStateById(Byte id);
    StateDTO createState(StateDTO stateDTO);
    StateDTO updateState(Byte id, StateDTO stateDTO);
    void deleteState(Byte id);
}
