package com.bank.service_transfer.service;

import com.bank.service_transfer.dto.TransferLimitDTO;

import java.util.List;

public interface TransferLimitService {

    List<TransferLimitDTO> getAllLimits();

    TransferLimitDTO getLimitByUserId(Long userId);

    TransferLimitDTO createLimit(TransferLimitDTO dto);

    TransferLimitDTO updateLimit(Long userId, TransferLimitDTO dto);

    void deleteLimit(Long userId);

    boolean existsLimitByUserId(Long userId);
}
