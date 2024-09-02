package com.week2.labs.ConcurrencyMultithreading.controller;

import com.week2.labs.ConcurrencyMultithreading.service.BankingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banking")
public class BankingController {
    private final BankingService bankingService;

    public BankingController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @PostMapping("/createAccount")
    public String createAccount(@RequestParam String accountNumber, @RequestParam double initialBalance) {
        bankingService.createAccount(accountNumber, initialBalance);
        return "Account created: " + accountNumber;
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String accountNumber, @RequestParam double amount) {
        bankingService.deposit(accountNumber, amount);
        return "Deposited " + amount + " to account: " + accountNumber;
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String accountNumber, @RequestParam double amount) {
        bankingService.withdraw(accountNumber, amount);
        return "Withdrew " + amount + " from account: " + accountNumber;
    }

    @GetMapping("/balance/concurrent")
    public double getConcurrentBalance(@RequestParam String accountNumber) {
        return bankingService.getConcurrentBalance(accountNumber);
    }

    @GetMapping("/balance/regular")
    public double getRegularBalance(@RequestParam String accountNumber) {
        return bankingService.getRegularBalance(accountNumber);
    }

    @GetMapping("/performance/concurrent")
    public long measureConcurrentMapPerformance() {
        return bankingService.measureConcurrentMapPerformance();
    }

    @GetMapping("/performance/regular")
    public long measureRegularMapPerformance() {
        return bankingService.measureRegularMapPerformance();
    }

    @PostMapping("/clearAccounts")
    public String clearAccounts() {
        bankingService.clearAccounts();
        return "All accounts cleared.";
    }
}
