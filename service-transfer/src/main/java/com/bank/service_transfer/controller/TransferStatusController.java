package com.bank.service_transfer.controller;

import com.bank.service_transfer.model.TransferStatus;
import com.bank.service_transfer.repository.TransferStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/statuses")
@RequiredArgsConstructor
public class TransferStatusController {

    private final TransferStatusRepository statusRepository;

    @GetMapping
    public ResponseEntity<List<TransferStatus>> getAllStatuses() {
        return ResponseEntity.ok(statusRepository.findAll());
    }
}
