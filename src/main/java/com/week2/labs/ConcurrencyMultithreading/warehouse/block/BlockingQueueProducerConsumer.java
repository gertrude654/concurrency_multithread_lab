package com.week2.labs.ConcurrencyMultithreading.warehouse.block;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

        Thread producerThread = new Thread(new BlockingQueueProducer(queue));
        Thread consumerThread = new Thread(new BlockingQueueConsumer(queue));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Warehouse closed.");
    }
}
