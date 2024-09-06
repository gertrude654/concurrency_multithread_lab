package com.week2.labs.ConcurrencyMultithreading.warehouse.basic;

import java.util.LinkedList;
import java.util.Queue;

public class Inventory {
    private final Queue<String> queue = new LinkedList<>();
    private final int capacity = 5;

    //produce method
    public synchronized void produce(int item) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(String.valueOf(item));
        notifyAll(); // Notify consumers that an item is available
    }

    //consume method
    public synchronized String consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        String item = queue.poll();
        notifyAll(); // Notify producers that space is available
        return item;
    }
}





