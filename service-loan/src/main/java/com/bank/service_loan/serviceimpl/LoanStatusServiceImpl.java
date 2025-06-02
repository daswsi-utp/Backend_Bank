package com.bank.service_loan.serviceimpl;

import com.bank.service_loan.model.LoanStatus;
import com.bank.service_loan.repository.LoanStatusRepository;
import com.bank.service_loan.service.LoanStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanStatusServiceImpl implements LoanStatusService {

    private final LoanStatusRepository loanStatusRepository;

    @Override
    public List<LoanStatus> getAllStatuses() {
        return loanStatusRepository.findAll();
    }
}
