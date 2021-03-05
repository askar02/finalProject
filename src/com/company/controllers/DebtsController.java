package com.company.controllers;

import com.company.entities.Debts;
import com.company.repositories.interfaces.IDebtsRepo;

import java.util.List;

public class DebtsController {
    private final IDebtsRepo repo;
    public DebtsController(IDebtsRepo repo) {
        this.repo = repo;
    }
    public String takeLoan(int loan_sum, int loan_plan) {
        boolean executed = repo.takeLoan(loan_plan, loan_sum);
        return (executed ? "Loan is successfully taken. You took " + loan_sum + " for " + loan_plan + " years and will pay " + loan_sum/loan_plan + " per month."
                : "Loan registration was denied");
    }

    public String getAllLoans() {
        List<Debts> allLoans = repo.getAllLoans();
        return (allLoans != null ? allLoans.toString() : "Your query is failed. Please try again later.");
    }
}