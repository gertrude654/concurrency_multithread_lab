package com.week2.labs.ConcurrencyMultithreading.threadControl;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 10_000;
    private long[] array;
    private int start, end;

    public SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if (end - start <= THRESHOLD) {
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);

            leftTask.fork();  // Fork the left task
            rightTask.fork(); // Fork the right task

            long leftResult = leftTask.join();   // Join the left task
            long rightResult = rightTask.join(); // Join the right task

            return leftResult + rightResult;
        }
    }
}
