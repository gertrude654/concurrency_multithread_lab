package com.week2.labs.ConcurrencyMultithreading.warehouse.block;

public class BlockingQueueConsumer implements Runnable {
    private final WarehouseBlockingQueue warehouse;
    private final int itemCount;

    public BlockingQueueConsumer(WarehouseBlockingQueue warehouse, int itemCount) {
        this.warehouse = warehouse;
        this.itemCount = itemCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < itemCount; i++) {
                warehouse.consume();
//                System.out.println("Consumed: " + i);
//                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Consumer interrupted: " + e.getMessage());

        }
    }
}
