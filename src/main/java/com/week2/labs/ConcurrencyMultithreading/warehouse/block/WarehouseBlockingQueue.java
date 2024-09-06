package com.week2.labs.ConcurrencyMultithreading.warehouse.block;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WarehouseBlockingQueue {
    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public void produce(int item) throws InterruptedException {
        queue.put(item);
    }

    public int consume() throws InterruptedException {
        return queue.take();
    }
}