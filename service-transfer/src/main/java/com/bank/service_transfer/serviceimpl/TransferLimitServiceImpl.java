package com.bank.service_transfer.serviceimpl;

import com.bank.service_transfer.dto.TransferLimitDTO;
import com.bank.service_transfer.model.TransferLimit;
import com.bank.service_transfer.repository.TransferLimitRepository;
import com.bank.service_transfer.service.TransferLimitService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransferLimitServiceImpl implements TransferLimitService {

    @Autowired
    private TransferLimitRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<TransferLimitDTO> getAllLimits() {
        return repository.findAll().stream()
                .map(limit -> mapper.map(limit, TransferLimitDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TransferLimitDTO getLimitByUserId(Long userId) {
        return repository.findById(userId)
                .map(limit -> mapper.map(limit, TransferLimitDTO.class))
                .orElse(null);
    }

    @Override
    public TransferLimitDTO createLimit(TransferLimitDTO dto) {
        TransferLimit limit = mapper.map(dto, TransferLimit.class);
        return mapper.map(repository.save(limit), TransferLimitDTO.class);
    }

    @Override
    public TransferLimitDTO updateLimit(Long userId, TransferLimitDTO dto) {
        if (!repository.existsById(userId)) return null;
        TransferLimit limit = mapper.map(dto, TransferLimit.class);
        limit.setUserId(userId);
        return mapper.map(repository.save(limit), TransferLimitDTO.class);
    }

    @Override
    public void deleteLimit(Long userId) {
        repository.deleteById(userId);
    }

    @Override
    public boolean existsLimitByUserId(Long userId) {
        return repository.existsByUserId(userId);
    }
}
