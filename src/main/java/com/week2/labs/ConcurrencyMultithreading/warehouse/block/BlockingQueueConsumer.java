package com.week2.labs.ConcurrencyMultithreading.warehouse.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class BlockingQueueConsumer implements Runnable {
    private final BlockingQueue<String> queue;

    public BlockingQueueConsumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                String item = queue.take(); // Blocking if queue is empty
                System.out.println("Consumed: " + item);
                Thread.sleep(200); // Simulate consumption time
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Consumer interrupted: " + e.getMessage());
        }
    }
}
