package day2.multithreading.lifecycles;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        // New State
        Thread thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(1000); // Simulating work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Thread1 state after creation: " + thread1.getState()); // Output: NEW

        // Runnable State
        thread1.start();
        System.out.println("Thread1 state after calling start(): " + thread1.getState()); // Output: RUNNABLE or RUNNING

        // Blocked State
        Thread thread2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread 2 acquired the lock");
            }
        });

        thread2.start();
        Thread.sleep(100); // Ensure thread2 attempts to acquire the lock after thread1

        System.out.println("Thread2 state after trying to acquire lock: " + thread2.getState()); // Output: BLOCKED

        // Waiting State
        Thread thread3 = new Thread(() -> {
            try {
                thread1.join(); // Thread3 waits for thread1 to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread3.start();
        Thread.sleep(100); // Ensure thread3 is in the waiting state

        System.out.println("Thread3 state after calling join(): " + thread3.getState()); // Output: WAITING

        // Timed Waiting State
        Thread thread4 = new Thread(() -> {
            try {
                Thread.sleep(500); // Thread will be in TIMED_WAITING state
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread4.start();
        Thread.sleep(100); // Ensure the thread has entered TIMED_WAITING state

        System.out.println("Thread4 state during sleep: " + thread4.getState()); // Output: TIMED_WAITING

        // Terminated State
        thread1.join(); // Wait for thread1 to finish
        System.out.println("Thread1 state after completion: " + thread1.getState()); // Output: TERMINATED
    }
}
