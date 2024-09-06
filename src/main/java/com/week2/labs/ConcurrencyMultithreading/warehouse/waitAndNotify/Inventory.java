package com.week2.labs.ConcurrencyMultithreading.warehouse.waitAndNotify;

import java.util.LinkedList;
import java.util.Queue;

public class Inventory {
    private final Queue<String> queue = new LinkedList<>();
    private final int capacity = 5;

    // Producer method
    public synchronized void produce(String item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait(); // Wait if the warehouse is full
        }
        queue.add(item);
        System.out.println("Produced: " + item);
        notifyAll(); // Notify consumers that a new item is available
    }

    // Consumer method
    public synchronized String consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait if the warehouse is empty
        }
        String item = queue.poll();
        notifyAll(); // Notify producers that there is space available
        return item;
    }
}
