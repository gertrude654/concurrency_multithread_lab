package com.week2.labs.ConcurrencyMultithreading;

// Task class that implements Runnable, which can be run by a thread
class Task implements Runnable {
    private String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    // The run method defines the code that will be executed by the thread
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Count: " + i);
            try {
                // Pausing the thread for 500 milliseconds to simulate work
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(taskName + " was interrupted.");
            }
        }
        System.out.println(taskName + " finished.");
    }
}

public class ConcurrencyExample {
    public static void main(String[] args) {
        // Creating two tasks to run concurrently
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");

        // Creating two threads and passing the tasks to them
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // Starting the threads
        thread1.start();
        thread2.start();

        // Main thread continues to run while the other threads are executing
        System.out.println("Main thread running concurrently.");
    }
}
