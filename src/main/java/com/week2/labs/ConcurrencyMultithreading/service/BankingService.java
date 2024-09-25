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

    // Create accounts in both maps
    public void createAccount(String accountNumber, double initialBalance) {
        concurrentAccounts.put(accountNumber, new BankAccount(accountNumber, initialBalance));
        regularAccounts.put(accountNumber, new BankAccount(accountNumber, initialBalance));
        logger.info("Created account: {}", accountNumber);
    }

    // Measure ConcurrentHashMap performance
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
    // Measure HashMap performance
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