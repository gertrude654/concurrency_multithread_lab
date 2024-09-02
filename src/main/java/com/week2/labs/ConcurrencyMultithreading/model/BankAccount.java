package com.week2.labs.ConcurrencyMultithreading.model;

public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited $" + amount + ". New balance: $" + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to withdraw $" + amount + ". Insufficient balance: $" + balance);
        }
    }

    public synchronized double getBalance() {
        System.out.println(Thread.currentThread().getName() + " checked balance: $" + balance);
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
