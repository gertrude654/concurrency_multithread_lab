package com.week2.labs.ConcurrencyMultithreading.warehouse.waitAndNotify;


public class Consumer implements Runnable {
    private final Inventory warehouse;

    public Consumer(Inventory warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                String item = warehouse.consume();
                System.out.println("Consumed: " + item);
                Thread.sleep(200); // Simulate consumption time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Consumer interrupted: " + e.getMessage());
        }
    }
}