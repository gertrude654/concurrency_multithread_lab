package com.week2.labs.ConcurrencyMultithreading.sychronization.deadlocks;

public class Scannere {
    public synchronized void scanDocument(String doc) {
        System.out.println("Scanning document: " + doc);
    }
}