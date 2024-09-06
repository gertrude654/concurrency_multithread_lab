package com.week2.labs.ConcurrencyMultithreading.warehouse.block;

public class BlockingQueueProducer implements Runnable {
    private final WarehouseBlockingQueue warehouse;
    private final int itemCount;

    public BlockingQueueProducer(WarehouseBlockingQueue warehouse, int itemCount) {
        this.warehouse = warehouse;
        this.itemCount = itemCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemCount; i++) {
                warehouse.produce(i);
//                System.out.println("Produced: " + i);
//                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Producer interrupted: " + e.getMessage());

        }
    }
}
