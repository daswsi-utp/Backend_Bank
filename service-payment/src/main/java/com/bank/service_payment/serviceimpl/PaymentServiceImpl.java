package com.bank.service_payment.serviceimpl;

import com.bank.service_payment.dto.CreatePaymentDTO;
import com.bank.service_payment.dto.PaymentDTO;
import com.bank.service_payment.model.Payment;
import com.bank.service_payment.model.ServiceEntity;
import com.bank.service_payment.repository.PaymentRepository;
import com.bank.service_payment.repository.ServiceRepository;
import com.bank.service_payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ServiceRepository serviceRepository;

    @Override
    public PaymentDTO createPayment(CreatePaymentDTO dto) {
        ServiceEntity service = serviceRepository.findById(dto.getServiceId())
                .orElseThrow(() -> new RuntimeException("Service not found"));

        Payment payment = Payment.builder()
                .userId(dto.getUserId())
                .service(service)
                .accountId(dto.getAccountId())
                .amount(dto.getAmount())
                .fee(dto.getFee())
                .referenceNumber(dto.getReferenceNumber())
                .barcode(dto.getBarcode())
                .build();

        return toDTO(paymentRepository.save(payment));
    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDTO getPaymentById(Long id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return toDTO(payment);
    }

    @Override
    public PaymentDTO getPaymentByReference(String referenceNumber) {
        Payment payment = paymentRepository.findByReferenceNumber(referenceNumber)
                .orElseThrow(() -> new RuntimeException("Reference not found"));
        return toDTO(payment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    private PaymentDTO toDTO(Payment payment) {
        return PaymentDTO.builder()
                .id(payment.getId())
                .userId(payment.getUserId())
                .serviceId(payment.getService().getId())
                .accountId(payment.getAccountId())
                .amount(payment.getAmount())
                .fee(payment.getFee())
                .referenceNumber(payment.getReferenceNumber())
                .barcode(payment.getBarcode())
                .date(payment.getDate())
                .build();
    }
}
