package com.bank.service_loan.service;

import com.bank.service_loan.model.Loan;
import java.util.List;

public interface LoanService {
    Loan createLoan(Loan loan);
    List<Loan> getAllLoans();

}
