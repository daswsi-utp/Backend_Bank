package com.bank.service_loan.serviceimpl;

import com.bank.service_loan.dto.LoanRequestDTO;
import com.bank.service_loan.dto.LoanResponseDTO;
import com.bank.service_loan.dto.LoanMapper;
import com.bank.service_loan.model.Loan;
import com.bank.service_loan.model.LoanStatus;
import com.bank.service_loan.repository.LoanRepository;
import com.bank.service_loan.repository.LoanStatusRepository;
import com.bank.service_loan.service.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final LoanStatusRepository loanStatusRepository;

    @Override
    public LoanResponseDTO createLoan(LoanRequestDTO dto) {
        LoanStatus status = loanStatusRepository.findById((byte) 1) // PENDIENTE
                .orElseThrow(() -> new IllegalArgumentException("Loan status not found"));

        Loan loan = LoanMapper.toEntity(dto, status);
        return LoanMapper.toDto(loanRepository.save(loan));
    }

    @Override
    public Optional<LoanResponseDTO> getLoanById(Long id) {
        return loanRepository.findById(id).map(LoanMapper::toDto);
    }

    @Override
    public List<LoanResponseDTO> getLoansByUserId(Long userId) {
        return loanRepository.findByUserId(userId).stream().map(LoanMapper::toDto).toList();
    }

    @Override
    public List<LoanResponseDTO> getAllLoans() {
        return loanRepository.findAll().stream().map(LoanMapper::toDto).toList();
    }

    @Override
    public LoanResponseDTO approveLoan(Long id, double approvedAmount) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Loan not found"));

        LoanStatus approvedStatus = loanStatusRepository.findById((byte) 2) // APROBADO
                .orElseThrow(() -> new IllegalArgumentException("Approved status not found"));

        loan.setApprovedAmount(BigDecimal.valueOf(approvedAmount));
        loan.setStatus(approvedStatus);

        return LoanMapper.toDto(loanRepository.save(loan));
    }
}
