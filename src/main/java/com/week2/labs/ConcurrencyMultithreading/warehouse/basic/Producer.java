package com.week2.labs.ConcurrencyMultithreading.warehouse.basic;


public class Producer implements Runnable {
    private final Inventory warehouse;
    private final int itemCount;

    public Producer(Inventory warehouse, int itemCount) {
        this.warehouse = warehouse;
        this.itemCount = itemCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemCount; i++) {
                warehouse.produce(i);
//                System.out.println("Produced: " + i);
//                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Producer interrupted: " + e.getMessage());

        }
    }
}
