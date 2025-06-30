package com.bank.service_catalog.controller;

import com.bank.service_catalog.dto.StateDTO;
import com.bank.service_catalog.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
@RequiredArgsConstructor
public class StateController {

    private final StateService stateService;

    @GetMapping
    public ResponseEntity<List<StateDTO>> getAllStates() {
        return ResponseEntity.ok(stateService.getAllStates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StateDTO> getStateById(@PathVariable Byte id) {
        return ResponseEntity.ok(stateService.getStateById(id));
    }

    @PostMapping
    public ResponseEntity<StateDTO> createState(@RequestBody StateDTO stateDTO) {
        return ResponseEntity.ok(stateService.createState(stateDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StateDTO> updateState(@PathVariable Byte id, @RequestBody StateDTO stateDTO) {
        return ResponseEntity.ok(stateService.updateState(id, stateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteState(@PathVariable Byte id) {
        stateService.deleteState(id);
        return ResponseEntity.noContent().build();
    }
}
