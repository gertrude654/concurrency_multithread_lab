package com.week2.labs.ConcurrencyMultithreading.service;

import com.week2.labs.ConcurrencyMultithreading.model.BankAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BankingService {
    private static final Logger logger = LoggerFactory.getLogger(BankingService.class);

    private Map<String, BankAccount> concurrentAccounts = new ConcurrentHashMap<>();
    private Map<String, BankAccount> regularAccounts = new HashMap<>();

    public void createAccount(String accountNumber, double initialBalance) {
        concurrentAccounts.put(accountNumber, new BankAccount(accountNumber, initialBalance));
        regularAccounts.put(accountNumber, new BankAccount(accountNumber, initialBalance));
        logger.info("Created account: {}", accountNumber);
    }

    public void deposit(String accountNumber, double amount) {
        BankAccount concurrentAccount = concurrentAccounts.get(accountNumber);
        BankAccount regularAccount = regularAccounts.get(accountNumber);
        if (concurrentAccount != null && regularAccount != null) {
            concurrentAccount.deposit(amount);
            regularAccount.deposit(amount);
            logger.info("Deposited {} to account: {}", amount, accountNumber);
        } else {
            logger.warn("Account not found for deposit: {}", accountNumber);
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankAccount concurrentAccount = concurrentAccounts.get(accountNumber);
        BankAccount regularAccount = regularAccounts.get(accountNumber);
        if (concurrentAccount != null && regularAccount != null) {
            concurrentAccount.withdraw(amount);
            regularAccount.withdraw(amount);
            logger.info("Withdrew {} from account: {}", amount, accountNumber);
        } else {
            logger.warn("Account not found for withdrawal: {}", accountNumber);
        }
    }

    public double getConcurrentBalance(String accountNumber) {
        BankAccount account = concurrentAccounts.get(accountNumber);
        double balance = (account != null) ? account.getBalance() : 0;
        logger.info("Balance for account {}: {}", accountNumber, balance);
        return balance;
    }

    public double getRegularBalance(String accountNumber) {
        BankAccount account = regularAccounts.get(accountNumber);
        double balance = (account != null) ? account.getBalance() : 0;
        logger.info("Balance for account {}: {}", accountNumber, balance);
        return balance;
    }

    public void clearAccounts() {
        concurrentAccounts.clear();
        regularAccounts.clear();
        logger.info("Cleared all accounts.");
    }

    public long measureConcurrentMapPerformance() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            concurrentAccounts.put("Account" + i, new BankAccount("Account" + i, 1000));
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        logger.info("ConcurrentHashMap performance duration: {} ns", duration);
        return duration;
    }

    public long measureRegularMapPerformance() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            regularAccounts.put("Account" + i, new BankAccount("Account" + i, 1000));
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        logger.info("HashMap performance duration: {} ns", duration);
        return duration;
    }
}
