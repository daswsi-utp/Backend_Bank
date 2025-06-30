package com.bank.service_transfer.serviceimpl;

import com.bank.service_transfer.dto.FeeDTO;
import com.bank.service_transfer.model.Fee;
import com.bank.service_transfer.repository.FeeRepository;
import com.bank.service_transfer.service.FeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeeServiceImpl implements FeeService {

    @Autowired
    private FeeRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<FeeDTO> getAllFees() {
        return repository.findAll().stream()
                .map(f -> mapper.map(f, FeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public FeeDTO getFeeById(Long id) {
        Fee fee = repository.findById(id).orElse(null);
        return (fee != null) ? mapper.map(fee, FeeDTO.class) : null;
    }

    @Override
    public FeeDTO createFee(FeeDTO dto) {
        Fee fee = mapper.map(dto, Fee.class);
        return mapper.map(repository.save(fee), FeeDTO.class);
    }

    @Override
    public FeeDTO updateFee(Long id, FeeDTO dto) {
        if (!repository.existsById(id)) return null;
        Fee fee = mapper.map(dto, Fee.class);
        fee.setId(id);
        return mapper.map(repository.save(fee), FeeDTO.class);
    }

    @Override
    public void deleteFee(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<FeeDTO> getFeesByTransferId(Long transferId) {
        return repository.findByTransferId(transferId).stream()
                .map(f -> mapper.map(f, FeeDTO.class))
                .collect(Collectors.toList());
    }
}
