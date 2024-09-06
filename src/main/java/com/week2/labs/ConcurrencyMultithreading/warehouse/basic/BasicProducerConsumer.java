package com.week2.labs.ConcurrencyMultithreading.warehouse.basic;


public class BasicProducerConsumer {
    public static void main(String[] args) {
        Inventory warehouse = new Inventory();

        Thread producerThread = new Thread(new Producer(warehouse,4));
        Thread consumerThread = new Thread(new Consumer(warehouse,4));

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
