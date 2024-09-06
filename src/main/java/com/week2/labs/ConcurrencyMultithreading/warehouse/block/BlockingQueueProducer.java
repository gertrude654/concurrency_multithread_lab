package com.week2.labs.ConcurrencyMultithreading.warehouse.block;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducer implements Runnable {
    private final BlockingQueue<String> queue;

    public BlockingQueueProducer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                queue.put("Item " + i); // Blocking if queue is full
                System.out.println("Produced: Item " + i);
                Thread.sleep(100); // Simulate production time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Producer interrupted: " + e.getMessage());
        }
    }
}
