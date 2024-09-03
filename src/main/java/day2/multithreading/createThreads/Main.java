package day2.multithreading.createThreads;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start(); // Start the thread

        MyThread thread1 = new MyThread();
        thread1.start(); // Start the thread
    }
}

