package com.bank.service_transfer.controller;

import com.bank.service_transfer.dto.TransferLimitDTO;
import com.bank.service_transfer.service.TransferLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/limits")
public class TransferLimitController {

    @Autowired
    private TransferLimitService service;

    @GetMapping
    public List<TransferLimitDTO> getAll() {
        return service.getAllLimits();
    }

    @GetMapping("/{userId}")
    public TransferLimitDTO getByUserId(@PathVariable Long userId) {
        return service.getLimitByUserId(userId);
    }

    @PostMapping
    public TransferLimitDTO create(@RequestBody TransferLimitDTO dto) {
        return service.createLimit(dto);
    }

    @PutMapping("/{userId}")
    public TransferLimitDTO update(@PathVariable Long userId, @RequestBody TransferLimitDTO dto) {
        return service.updateLimit(userId, dto);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId) {
        service.deleteLimit(userId);
    }
}
