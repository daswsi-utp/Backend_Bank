package com.bank.service_loan.serviceimpl;

import com.bank.service_loan.dto.LoanRequestDTO;
import com.bank.service_loan.dto.LoanResponseDTO;
import com.bank.service_loan.model.Loan;
import com.bank.service_loan.repository.LoanRepository;
import com.bank.service_loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    @Override
    public LoanResponseDTO createLoan(LoanRequestDTO request) {
        Loan loan = Loan.builder().build();
        BeanUtils.copyProperties(request, loan);
        loan = loanRepository.save(loan);
        return toResponseDTO(loan);
    }

    @Override
    public LoanResponseDTO getLoanById(Long id) {
        return loanRepository.findById(id)
                .map(this::toResponseDTO)
                .orElse(null);
    }

    @Override
    public List<LoanResponseDTO> getAllLoans() {
        return loanRepository.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LoanResponseDTO> getLoansByUserId(Long userId) {
        return loanRepository.findByUserId(userId).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LoanResponseDTO updateLoan(Long id, LoanRequestDTO request) {
        return loanRepository.findById(id).map(existing -> {
            BeanUtils.copyProperties(request, existing, "id");
            return toResponseDTO(loanRepository.save(existing));
        }).orElse(null);
    }

    @Override
    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    private LoanResponseDTO toResponseDTO(Loan loan) {
        return LoanResponseDTO.builder()
                .id(loan.getId())
                .userId(loan.getUserId())
                .requestedAmount(loan.getRequestedAmount())
                .approvedAmount(loan.getApprovedAmount())
                .loanTypeId(loan.getLoanTypeId())
                .interestRate(loan.getInterestRate())
                .installments(loan.getInstallments())
                .loanStatusId(loan.getLoanStatusId())
                .requestDate(loan.getRequestDate())
                .approvalDate(loan.getApprovalDate())
                .dueDate(loan.getDueDate())
                .build();
    }
}
