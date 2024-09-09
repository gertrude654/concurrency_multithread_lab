package com.week2.labs.ConcurrencyMultithreading.sychronization.variables;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingLot {
    private int availableSpaces;
    private Lock lock = new ReentrantLock();
    private Condition spaceAvailable = lock.newCondition();

    public ParkingLot(int spaces) {
        this.availableSpaces = spaces;
    }

    public void park(String car) {
        lock.lock();
        try {
            while (availableSpaces == 0) {
                System.out.println(car + " waiting for parking space.");
                spaceAvailable.await();
            }
            availableSpaces--;
            System.out.println(car + " parked. Spaces left: " + availableSpaces);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void leave(String car) {
        lock.lock();
        try {
            availableSpaces++;
            System.out.println(car + " left. Spaces available: " + availableSpaces);
            spaceAvailable.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
