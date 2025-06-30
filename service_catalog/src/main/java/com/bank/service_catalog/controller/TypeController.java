package com.bank.service_catalog.controller;

import com.bank.service_catalog.dto.TypeDTO;
import com.bank.service_catalog.service.TypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
@RequiredArgsConstructor
public class TypeController {

    private final TypeService typeService;

    @GetMapping
    public ResponseEntity<List<TypeDTO>> getAllTypes() {
        return ResponseEntity.ok(typeService.getAllTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDTO> getTypeById(@PathVariable Byte id) {
        return ResponseEntity.ok(typeService.getTypeById(id));
    }

    @PostMapping
    public ResponseEntity<TypeDTO> createType(@RequestBody TypeDTO typeDTO) {
        return ResponseEntity.ok(typeService.createType(typeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeDTO> updateType(@PathVariable Byte id, @RequestBody TypeDTO typeDTO) {
        return ResponseEntity.ok(typeService.updateType(id, typeDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteType(@PathVariable Byte id) {
        typeService.deleteType(id);
        return ResponseEntity.noContent().build();
    }
}
