package com.bank.service_payment.serviceimpl;

import com.bank.service_payment.dto.ServiceDTO;
import com.bank.service_payment.model.ServiceEntity;
import com.bank.service_payment.repository.ServiceRepository;
import com.bank.service_payment.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public ServiceDTO createService(ServiceDTO dto) {
        ServiceEntity entity = ServiceEntity.builder()
                .name(dto.getName())
                .code(dto.getCode())
                .isActive(dto.getIsActive())
                .build();
        return toDTO(serviceRepository.save(entity));
    }

    @Override
    public List<ServiceDTO> getAllServices() {
        return serviceRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ServiceDTO getServiceById(Integer id) {
        ServiceEntity entity = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        return toDTO(entity);
    }

    @Override
    public ServiceDTO updateService(Integer id, ServiceDTO dto) {
        ServiceEntity entity = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        entity.setIsActive(dto.getIsActive());
        return toDTO(serviceRepository.save(entity));
    }

    @Override
    public void deleteService(Integer id) {
        serviceRepository.deleteById(id);
    }

    private ServiceDTO toDTO(ServiceEntity entity) {
        return ServiceDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .code(entity.getCode())
                .isActive(entity.getIsActive())
                .build();
    }
}
