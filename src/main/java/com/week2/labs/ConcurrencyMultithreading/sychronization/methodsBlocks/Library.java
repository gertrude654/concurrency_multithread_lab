package com.week2.labs.ConcurrencyMultithreading.sychronization.methodsBlocks;

public class Library {
    private int availableRooms = 1;

    // Synchronized method for reserving a room
    public synchronized void reserveRoom(String user) {
        if (availableRooms > 0) {
            System.out.println(user + " reserved the study room.");
            availableRooms--;
        } else {
            System.out.println(user + " couldn't reserve the study room. No rooms left.");
        }
    }

    // Synchronized block for releasing a room
    public void releaseRoom(String user) {
        synchronized (this) {
            availableRooms++;
            System.out.println(user + " released the study room.");
        }
    }
}
