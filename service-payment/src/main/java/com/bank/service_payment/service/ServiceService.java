package com.bank.service_payment.service;

import com.bank.service_payment.dto.ServiceDTO;

import java.util.List;

public interface ServiceService {
    ServiceDTO createService(ServiceDTO serviceDTO);
    List<ServiceDTO> getAllServices();
    ServiceDTO getServiceById(Integer id);
    ServiceDTO updateService(Integer id, ServiceDTO serviceDTO);
    void deleteService(Integer id);
}
