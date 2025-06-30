package com.bank.service_transfer.controller;

import com.bank.service_transfer.dto.FeeDTO;
import com.bank.service_transfer.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
public class FeeController {

    @Autowired
    private FeeService service;

    @GetMapping
    public List<FeeDTO> getAll() {
        return service.getAllFees();
    }

    @GetMapping("/{id}")
    public FeeDTO getById(@PathVariable Long id) {
        return service.getFeeById(id);
    }

    @PostMapping
    public FeeDTO create(@RequestBody FeeDTO dto) {
        return service.createFee(dto);
    }

    @PutMapping("/{id}")
    public FeeDTO update(@PathVariable Long id, @RequestBody FeeDTO dto) {
        return service.updateFee(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteFee(id);
    }

    // Consultas adicionales
    @GetMapping("/transfer/{transferId}")
    public List<FeeDTO> getByTransferId(@PathVariable Long transferId) {
        return service.getFeesByTransferId(transferId);
    }
}
