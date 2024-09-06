package com.week2.labs.ConcurrencyMultithreading.warehouse.basic;


public class Consumer implements Runnable {
    private final Inventory warehouse;
    private final int itemCount;

    public Consumer(Inventory warehouse, int itemCount) {
        this.warehouse = warehouse;
        this.itemCount = itemCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemCount; i++) {
                warehouse.consume();
//                System.out.println("Consumed: " + i);
//                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}