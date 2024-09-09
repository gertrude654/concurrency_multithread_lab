package com.week2.labs.ConcurrencyMultithreading.sychronization.deadlocks;


public class DeadlockExample {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Scannere scanner = new Scannere();

        OfficeWorker worker1 = new OfficeWorker(printer, scanner, "Doc1");
        OfficeWorker worker2 = new OfficeWorker(printer, scanner, "Doc2");

        worker1.start();
        worker2.start();
    }
}
