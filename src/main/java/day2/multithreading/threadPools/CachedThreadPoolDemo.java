package day2.multithreading.threadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {
    public static void main(String[] args) {
        // Create a cached thread pool
        ExecutorService executor = Executors.newCachedThreadPool();

        // Submit tasks to the thread pool
        for (int i = 1; i <= 5; i++) {
            Runnable task = new WorkerThread("Task " + i);
            executor.execute(task);
        }

        // Shut down the executor
        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all tasks to finish
        }

        System.out.println("All tasks are completed.");
    }
}
