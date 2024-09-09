package com.week2.labs.ConcurrencyMultithreading.sychronization.deadlocks;

public class Printer {
    public synchronized void printDocument(String doc) {
        System.out.println("Printing document: " + doc);
    }
}

