package day2.multithreading.threadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutorDemo {
    public static void main(String[] args) {
        // Create a single-threaded executor
        ExecutorService executor = Executors.newSingleThreadExecutor();

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
