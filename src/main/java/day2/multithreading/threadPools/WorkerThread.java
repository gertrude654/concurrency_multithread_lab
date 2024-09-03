package day2.multithreading.threadPools;

class WorkerThread implements Runnable {
    private String taskName;

    public WorkerThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " executing " + taskName);
        try {
            Thread.sleep(2000); // Simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished " + taskName);
    }
}
