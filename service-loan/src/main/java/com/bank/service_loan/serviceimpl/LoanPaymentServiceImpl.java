package com.bank.service_loan.serviceimpl;

import com.bank.service_loan.dto.LoanPaymentDTO;
import com.bank.service_loan.dto.LoanMapper;
import com.bank.service_loan.model.Loan;
import com.bank.service_loan.model.LoanPayment;
import com.bank.service_loan.repository.LoanPaymentRepository;
import com.bank.service_loan.repository.LoanRepository;
import com.bank.service_loan.service.LoanPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanPaymentServiceImpl implements LoanPaymentService {

    private final LoanRepository loanRepository;
    private final LoanPaymentRepository paymentRepository;

    @Override
    public LoanPaymentDTO registerPayment(Long loanId, BigDecimal amount) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new IllegalArgumentException("Loan not found"));

        LoanPayment payment = LoanPayment.builder()
                .loan(loan)
                .amountPaid(amount)
                .build();

        return LoanMapper.toDto(paymentRepository.save(payment));
    }

    @Override
    public List<LoanPaymentDTO> getPaymentsByLoanId(Long loanId) {
        return paymentRepository.findByLoanId(loanId)
                .stream().map(LoanMapper::toDto).toList();
    }
}
