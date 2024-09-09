package com.week2.labs.ConcurrencyMultithreading.sychronization.deadlocks.prevention;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OfficeWorkerAvoidDeadlock extends Thread {
    private Lock printerLock;
    private Lock scannerLock;
    private String document;

    public OfficeWorkerAvoidDeadlock(Lock printerLock, Lock scannerLock, String document) {
        this.printerLock = printerLock;
        this.scannerLock = scannerLock;
        this.document = document;
    }

    public void run() {
        try {
            if (printerLock.tryLock()) {
                System.out.println(Thread.currentThread().getName() + " got the printer.");
                Thread.sleep(100); // Simulate printing time

                if (scannerLock.tryLock()) {
                    System.out.println(Thread.currentThread().getName() + " got the scanner.");
                    // Simulate document processing
                }
                scannerLock.unlock();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            printerLock.unlock();
        }
    }
}

