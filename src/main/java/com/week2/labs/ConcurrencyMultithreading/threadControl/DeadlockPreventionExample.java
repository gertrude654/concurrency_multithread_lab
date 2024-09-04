package com.week2.labs.ConcurrencyMultithreading.threadControl;

public class DeadlockPreventionExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");

                try { Thread.sleep(1000); } catch (InterruptedException e) {}

                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 1: Holding lock 1 and lock 2...");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock1) {  // Both threads acquire lock1 first
                System.out.println("Thread 2: Holding lock 1...");

                try { Thread.sleep(1000); } catch (InterruptedException e) {}

                System.out.println("Thread 2: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 2: Holding lock 1 and lock 2...");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
