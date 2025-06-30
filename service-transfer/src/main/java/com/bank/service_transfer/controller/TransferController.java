package com.bank.service_transfer.controller;

import com.bank.service_transfer.dto.TransferDTO;
import com.bank.service_transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    @Autowired
    private TransferService service;

    @GetMapping
    public List<TransferDTO> getAll() {
        return service.getAllTransfers();
    }

    @GetMapping("/{id}")
    public TransferDTO getById(@PathVariable Long id) {
        return service.getTransferById(id);
    }

    @PostMapping
    public TransferDTO create(@RequestBody TransferDTO dto) {
        return service.createTransfer(dto);
    }

    @PutMapping("/{id}")
    public TransferDTO update(@PathVariable Long id, @RequestBody TransferDTO dto) {
        return service.updateTransfer(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteTransfer(id);
    }

    // Consultas adicionales
    @GetMapping("/source/{accountId}")
    public List<TransferDTO> getBySourceAccount(@PathVariable Long accountId) {
        return service.getTransfersBySourceAccount(accountId);
    }

    @GetMapping("/destination/{accountId}")
    public List<TransferDTO> getByDestinationAccount(@PathVariable Long accountId) {
        return service.getTransfersByDestinationAccount(accountId);
    }

    @GetMapping("/estado/{estadoId}")
    public List<TransferDTO> getByEstado(@PathVariable Byte estadoId) {
        return service.getTransfersByEstadoId(estadoId);
    }
}
