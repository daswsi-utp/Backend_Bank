package com.bank.service_loan.model;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientId;
    private Double amount;
    private Double interestRate;
    private LocalDate startDate;
    private Integer termMonths;

    //Getters and Setters

    public Long getId() {
        return id;
    } 

    public void setClientId(String clientId) {
        this.clientId = clientId;
    } 
    public String getClientId() {
        return clientId;
    } 
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public Double getAmount() {
        return amount;
    }
    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }
    
    public Double getInterestRate() {
        return interestRate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setTermMonths(Integer termMonths) {
        this.termMonths = termMonths;
    }
    
    public Integer getTermMonths() {
        return termMonths;
    }
}
