package com.week2.labs.ConcurrencyMultithreading.warehouse.waitAndNotify;


public class Producer implements Runnable {
    private final Inventory warehouse;

    public Producer(Inventory warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                warehouse.produce("Item " + i);
                Thread.sleep(100); // Simulate production time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Producer interrupted: " + e.getMessage());
        }
    }
}

