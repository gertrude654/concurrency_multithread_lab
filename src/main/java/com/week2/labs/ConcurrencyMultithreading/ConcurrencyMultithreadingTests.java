package com.week2.labs.ConcurrencyMultithreading;

import com.week2.labs.ConcurrencyMultithreading.model.BankAccount;
import com.week2.labs.ConcurrencyMultithreading.service.BankingService;

public class ConcurrencyMultithreadingTests {
    public static void main(String[] args) {
        // 1. Test multithreading with BankAccount
        BankAccount account = new BankAccount("123456", 1000);
        System.out.println("=== Testing BankAccount with Multithreading ===");

        Runnable depositTask = () -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(100);
            }
        };

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(50);
            }
        };

        Thread thread1 = new Thread(depositTask, "Thread-1");
        Thread thread2 = new Thread(withdrawTask, "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: $" + account.getBalance());

        // 2. Test performance of ConcurrentHashMap vs HashMap
        System.out.println("\n=== Performance Comparison between ConcurrentHashMap and HashMap ===");

        BankingService service = new BankingService();
        long concurrentDuration = service.measureConcurrentMapPerformance();
        long regularDuration = service.measureRegularMapPerformance();

        System.out.println("ConcurrentHashMap performance: " + concurrentDuration + " ns");
        System.out.println("HashMap performance: " + regularDuration + " ns");
    }
}
