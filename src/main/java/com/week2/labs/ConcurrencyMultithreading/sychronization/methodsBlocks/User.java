package com.week2.labs.ConcurrencyMultithreading.sychronization.methodsBlocks;


public class User extends Thread {
    private Library library;
    private String userName;

    public User(Library library, String userName) {
        this.library = library;
        this.userName = userName;
    }

    public void run() {
        library.reserveRoom(userName);
        try {
            Thread.sleep(100);  // Simulate time spent in the room
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        library.releaseRoom(userName);
    }
}
