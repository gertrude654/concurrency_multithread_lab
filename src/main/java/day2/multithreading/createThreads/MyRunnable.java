package day2.multithreading.createThreads;

public class MyRunnable implements Runnable {

    private int threadNumber;

    public MyRunnable(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        System.out.println("Thread is running using Runnable.");
        for (int  i =0; i<4; i++){
            System.out.println(i + "from thread" + threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


