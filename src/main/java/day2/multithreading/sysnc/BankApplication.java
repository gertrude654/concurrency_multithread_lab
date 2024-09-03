package day2.multithreading.sysnc;


public class BankApplication {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00); // Initial balance

        // Creating multiple transactions
        Thread t1 = new Thread(new Transaction(account, 200.00, true), "Thread 1");
        Thread t2 = new Thread(new Transaction(account, 300.00, false), "Thread 2");
        Thread t3 = new Thread(new Transaction(account, 150.00, true), "Thread 3");
        Thread t4 = new Thread(new Transaction(account, 500.00, false), "Thread 4");

        // Starting the threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        // Wait for all threads to finish
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final balance
        System.out.println("Final account balance: " + account.getBalance());
    }
}

