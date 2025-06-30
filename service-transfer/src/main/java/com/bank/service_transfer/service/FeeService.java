package com.bank.service_transfer.service;

import com.bank.service_transfer.dto.FeeDTO;

import java.util.List;

public interface FeeService {

    List<FeeDTO> getAllFees();

    FeeDTO getFeeById(Long id);

    FeeDTO createFee(FeeDTO dto);

    FeeDTO updateFee(Long id, FeeDTO dto);

    void deleteFee(Long id);

    List<FeeDTO> getFeesByTransferId(Long transferId);
}
