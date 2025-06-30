package com.bank.service_transfer.serviceimpl;

import com.bank.service_transfer.dto.TransferDTO;
import com.bank.service_transfer.model.Transfer;
import com.bank.service_transfer.repository.TransferRepository;
import com.bank.service_transfer.service.TransferService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<TransferDTO> getAllTransfers() {
        return repository.findAll().stream()
                .map(t -> mapper.map(t, TransferDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TransferDTO getTransferById(Long id) {
        Transfer transfer = repository.findById(id).orElse(null);
        return (transfer != null) ? mapper.map(transfer, TransferDTO.class) : null;
    }

    @Override
    public TransferDTO createTransfer(TransferDTO dto) {
        Transfer transfer = mapper.map(dto, Transfer.class);
        return mapper.map(repository.save(transfer), TransferDTO.class);
    }

    @Override
    public TransferDTO updateTransfer(Long id, TransferDTO dto) {
        if (!repository.existsById(id)) return null;
        Transfer transfer = mapper.map(dto, Transfer.class);
        transfer.setId(id);
        return mapper.map(repository.save(transfer), TransferDTO.class);
    }

    @Override
    public void deleteTransfer(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TransferDTO> getTransfersBySourceAccount(Long sourceAccount) {
        return repository.findBySourceAccount(sourceAccount)
                .stream().map(t -> mapper.map(t, TransferDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TransferDTO> getTransfersByDestinationAccount(Long destinationAccount) {
        return repository.findByDestinationAccount(destinationAccount)
                .stream().map(t -> mapper.map(t, TransferDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TransferDTO> getTransfersByEstadoId(Byte estadoId) {
        return repository.findByEstadoId(estadoId)
                .stream().map(t -> mapper.map(t, TransferDTO.class))
                .collect(Collectors.toList());
    }
}
