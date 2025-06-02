package com.bank.service_fraud.controller;

import com.bank.service_fraud.model.TransactionAlertType;
import com.bank.service_fraud.service.TransactionAlertTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alert-types")
@RequiredArgsConstructor
public class TransactionAlertTypeController {

    private final TransactionAlertTypeService service;

    @GetMapping
    public ResponseEntity<List<TransactionAlertType>> getAllTypes() {
        return ResponseEntity.ok(service.getAllTypes());
    }
}
