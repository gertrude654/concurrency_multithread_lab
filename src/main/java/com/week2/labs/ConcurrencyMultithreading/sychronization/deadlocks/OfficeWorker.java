package com.week2.labs.ConcurrencyMultithreading.sychronization.deadlocks;

public class OfficeWorker extends Thread {
    private Printer printer;
    private Scannere scanner;
    private String document;

    public OfficeWorker(Printer printer, Scannere scanner, String document) {
        this.printer = printer;
        this.scanner = scanner;
        this.document = document;
    }

    public void run() {
        synchronized (printer) {
            System.out.println(Thread.currentThread().getName() + " got the printer.");
            synchronized (scanner) {
                System.out.println(Thread.currentThread().getName() + " got the scanner.");
                printer.printDocument(document);
                scanner.scanDocument(document);
            }
        }
    }
}
