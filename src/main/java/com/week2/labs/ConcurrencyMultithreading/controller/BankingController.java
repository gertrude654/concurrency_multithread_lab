package com.week2.labs.ConcurrencyMultithreading.controller;

import com.week2.labs.ConcurrencyMultithreading.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank")
public class BankingController {

    @Autowired
    private BankingService bankingService;

    @PostMapping("/create")
    public void createAccount(@RequestParam String accountNumber, @RequestParam double initialBalance) {
        bankingService.createAccount(accountNumber, initialBalance);
    }

    @PostMapping("/deposit")
    public void deposit(@RequestParam String accountNumber, @RequestParam double amount) {
        bankingService.deposit(accountNumber, amount);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestParam String accountNumber, @RequestParam double amount) {
        bankingService.withdraw(accountNumber, amount);
    }

    @GetMapping("/balance")
    public double getBalance(@RequestParam String accountNumber) {
        return bankingService.getBalance(accountNumber);
    }
}
