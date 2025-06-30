package com.bank.service_transfer.service;

import com.bank.service_transfer.dto.TransferDTO;

import java.util.List;

public interface TransferService {

    List<TransferDTO> getAllTransfers();

    TransferDTO getTransferById(Long id);

    TransferDTO createTransfer(TransferDTO dto);

    TransferDTO updateTransfer(Long id, TransferDTO dto);

    void deleteTransfer(Long id);

    List<TransferDTO> getTransfersBySourceAccount(Long sourceAccount);

    List<TransferDTO> getTransfersByDestinationAccount(Long destinationAccount);

    List<TransferDTO> getTransfersByEstadoId(Byte estadoId);
}
