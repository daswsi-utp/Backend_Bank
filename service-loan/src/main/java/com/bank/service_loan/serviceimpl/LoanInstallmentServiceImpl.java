package com.bank.service_loan.serviceimpl;

import com.bank.service_loan.dto.LoanInstallmentRequestDTO;
import com.bank.service_loan.dto.LoanInstallmentResponseDTO;
import com.bank.service_loan.model.Loan;
import com.bank.service_loan.model.LoanInstallment;
import com.bank.service_loan.repository.LoanInstallmentRepository;
import com.bank.service_loan.repository.LoanRepository;
import com.bank.service_loan.service.LoanInstallmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanInstallmentServiceImpl implements LoanInstallmentService {

    private final LoanInstallmentRepository installmentRepository;
    private final LoanRepository loanRepository;

    @Override
    public LoanInstallmentResponseDTO createInstallment(LoanInstallmentRequestDTO request) {
        Loan loan = loanRepository.findById(request.getLoanId()).orElseThrow();
        LoanInstallment installment = LoanInstallment.builder()
                .loan(loan)
                .installmentNumber(request.getInstallmentNumber())
                .amount(request.getAmount())
                .dueDate(request.getDueDate())
                .installmentStatusId(request.getInstallmentStatusId())
                .paymentDate(request.getPaymentDate())
                .build();
        return toResponseDTO(installmentRepository.save(installment));
    }

    @Override
    public LoanInstallmentResponseDTO getInstallmentById(Long id) {
        return installmentRepository.findById(id)
                .map(this::toResponseDTO)
                .orElse(null);
    }

    @Override
    public List<LoanInstallmentResponseDTO> getInstallmentsByLoanId(Long loanId) {
        return installmentRepository.findByLoanId(loanId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LoanInstallmentResponseDTO updateInstallment(Long id, LoanInstallmentRequestDTO request) {
        return installmentRepository.findById(id).map(existing -> {
            existing.setInstallmentNumber(request.getInstallmentNumber());
            existing.setAmount(request.getAmount());
            existing.setDueDate(request.getDueDate());
            existing.setInstallmentStatusId(request.getInstallmentStatusId());
            existing.setPaymentDate(request.getPaymentDate());
            return toResponseDTO(installmentRepository.save(existing));
        }).orElse(null);
    }

    @Override
    public void deleteInstallment(Long id) {
        installmentRepository.deleteById(id);
    }

    private LoanInstallmentResponseDTO toResponseDTO(LoanInstallment installment) {
        return LoanInstallmentResponseDTO.builder()
                .id(installment.getId())
                .installmentNumber(installment.getInstallmentNumber())
                .amount(installment.getAmount())
                .dueDate(installment.getDueDate())
                .installmentStatusId(installment.getInstallmentStatusId())
                .paymentDate(installment.getPaymentDate())
                .build();
    }
}
