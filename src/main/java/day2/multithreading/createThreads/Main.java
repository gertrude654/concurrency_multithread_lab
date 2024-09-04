package day2.multithreading.createThreads;

public class Main {
    public static void main(String[] args) {
        //creating 3 threads
        for(int j = 0; j < 3; j++){
            Thread thread = new Thread(new MyRunnable(j));
            thread.start();
        }

        MyThread thread1 = new MyThread();
        thread1.start(); // Start the thread
    }
}

