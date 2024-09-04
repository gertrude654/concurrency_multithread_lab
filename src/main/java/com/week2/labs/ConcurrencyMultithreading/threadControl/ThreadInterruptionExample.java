package com.week2.labs.ConcurrencyMultithreading.threadControl;

public class ThreadInterruptionExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread is running...");
                    Thread.sleep(1000);  // Simulate work
                }
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted during sleep.");
                Thread.currentThread().interrupt();  // Restore interrupt status
            }
            System.out.println("Thread is exiting...");
        });

        thread.start();

        try {
            Thread.sleep(6000);  // Main thread sleeps for a while
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();  // Interrupt the worker thread
    }
}
