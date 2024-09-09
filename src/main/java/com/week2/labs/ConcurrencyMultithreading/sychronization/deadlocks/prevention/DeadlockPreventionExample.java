package com.week2.labs.ConcurrencyMultithreading.sychronization.deadlocks.prevention;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockPreventionExample {
    public static void main(String[] args) {
        Lock printerLock = new ReentrantLock();
        Lock scannerLock = new ReentrantLock();

        OfficeWorkerAvoidDeadlock worker1 = new OfficeWorkerAvoidDeadlock(printerLock, scannerLock, "Doc1");
        OfficeWorkerAvoidDeadlock worker2 = new OfficeWorkerAvoidDeadlock(scannerLock, printerLock, "Doc2");

        worker1.start();
        worker2.start();
    }
}
