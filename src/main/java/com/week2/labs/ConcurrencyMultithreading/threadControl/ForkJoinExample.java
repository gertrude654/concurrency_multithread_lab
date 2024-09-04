package com.week2.labs.ConcurrencyMultithreading.threadControl;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;


public class ForkJoinExample {
    public static void main(String[] args) {
        long[] array = new long[100_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;  // Fill array with values
        }

        ForkJoinPool pool = new ForkJoinPool();
        SumTask task = new SumTask(array, 0, array.length);
        long result = pool.invoke(task);

        System.out.println("Sum: " + result);
    }
}
