package com.week2.labs.ConcurrencyMultithreading.service;//package com.week2.labs.ConcurrencyMultithreading.service;
//
//import com.week2.labs.ConcurrencyMultithreading.model.BankAccount;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Service
//public class BankingService {
//    private Map<String, BankAccount> accounts = new ConcurrentHashMap<>();
//
//    public void createAccount(String accountNumber, double initialBalance) {
//        accounts.put(accountNumber, new BankAccount(accountNumber, initialBalance));
//    }
//
//    public void deposit(String accountNumber, double amount) {
//        BankAccount account = accounts.get(accountNumber);
//        if (account != null) {
//            account.deposit(amount);
//        }
//    }
//
//    public void withdraw(String accountNumber, double amount) {
//        BankAccount account = accounts.get(accountNumber);
//        if (account != null) {
//            account.withdraw(amount);
//        }
//    }
//
//    public double getBalance(String accountNumber) {
//        BankAccount account = accounts.get(accountNumber);
//        if (account != null) {
//            return account.getBalance();
//        }
//        return 0;
//    }
//}
//

import com.week2.labs.ConcurrencyMultithreading.model.BankAccount;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BankingService {
    private Map<String, BankAccount> concurrentAccounts = new ConcurrentHashMap<>();
    private Map<String, BankAccount> nonConcurrentAccounts = new HashMap<>();

    public void createAccount(String accountNumber, double initialBalance, boolean concurrent) {
        if (concurrent) {
            concurrentAccounts.put(accountNumber, new BankAccount(accountNumber, initialBalance));
        } else {
            nonConcurrentAccounts.put(accountNumber, new BankAccount(accountNumber, initialBalance));
        }
    }

    public void deposit(String accountNumber, double amount, boolean concurrent) {
        BankAccount account = concurrent ? concurrentAccounts.get(accountNumber) : nonConcurrentAccounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        }
    }

    public void withdraw(String accountNumber, double amount, boolean concurrent) {
        BankAccount account = concurrent ? concurrentAccounts.get(accountNumber) : nonConcurrentAccounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        }
    }

    public double getBalance(String accountNumber, boolean concurrent) {
        BankAccount account = concurrent ? concurrentAccounts.get(accountNumber) : nonConcurrentAccounts.get(accountNumber);
        if (account != null) {
            return account.getBalance();
        }
        return 0;
    }

    public void clearAccounts() {
        concurrentAccounts.clear();
        nonConcurrentAccounts.clear();
    }
}

