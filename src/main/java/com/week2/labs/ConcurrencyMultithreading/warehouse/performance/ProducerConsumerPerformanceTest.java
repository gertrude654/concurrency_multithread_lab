package com.week2.labs.ConcurrencyMultithreading.warehouse.performance;

import com.week2.labs.ConcurrencyMultithreading.warehouse.basic.Consumer;
import com.week2.labs.ConcurrencyMultithreading.warehouse.basic.Inventory;
import com.week2.labs.ConcurrencyMultithreading.warehouse.basic.Producer;
import com.week2.labs.ConcurrencyMultithreading.warehouse.block.BlockingQueueConsumer;
import com.week2.labs.ConcurrencyMultithreading.warehouse.block.BlockingQueueProducer;
import com.week2.labs.ConcurrencyMultithreading.warehouse.block.WarehouseBlockingQueue;

public class ProducerConsumerPerformanceTest {
    private static final int ITEM_COUNT = 100000; // Total number of items to produce and consume

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Performance Test - Producer-Consumer");

        // Test BlockingQueue implementation
        System.out.println("Testing BlockingQueue...");
        long blockingQueueTime = testBlockingQueue();
        System.out.println("BlockingQueue time: " + blockingQueueTime + " ms");

        // Test wait/notify implementation
        System.out.println("Testing wait/notify...");
        long waitNotifyTime = testWaitNotify();
        System.out.println("Wait/Notify time: " + waitNotifyTime + " ms");

        // Performance comparison
        System.out.println("\nPerformance Comparison:");
        if (blockingQueueTime < waitNotifyTime) {
            System.out.println("BlockingQueue is faster by " + (waitNotifyTime - blockingQueueTime) + " ms.");
        } else {
            System.out.println("Wait/Notify is faster by " + (blockingQueueTime - waitNotifyTime) + " ms.");
        }
    }

    // Method to test BlockingQueue performance
    private static long testBlockingQueue() throws InterruptedException {
        WarehouseBlockingQueue warehouse = new WarehouseBlockingQueue();
        Thread producerThread = new Thread(new BlockingQueueProducer(warehouse, ITEM_COUNT));
        Thread consumerThread = new Thread(new BlockingQueueConsumer(warehouse, ITEM_COUNT));

        long startTime = System.currentTimeMillis();
        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
        long endTime = System.currentTimeMillis();

        return endTime - startTime; // Return the time taken in milliseconds
    }

    // Method to test wait/notify performance
    private static long testWaitNotify() throws InterruptedException {
        Inventory warehouse = new Inventory();
        Thread producerThread = new Thread(new Consumer(warehouse, ITEM_COUNT));
        Thread consumerThread = new Thread(new Producer(warehouse, ITEM_COUNT));

        long startTime = System.currentTimeMillis();
        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();
        long endTime = System.currentTimeMillis();

        return endTime - startTime; // Return the time taken in milliseconds
    }
}
