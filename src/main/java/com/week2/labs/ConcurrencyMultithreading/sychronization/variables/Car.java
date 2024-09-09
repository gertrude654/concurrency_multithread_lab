package com.week2.labs.ConcurrencyMultithreading.sychronization.variables;

public class Car extends Thread {
    private ParkingLot parkingLot;
    private String carName;

    public Car(ParkingLot parkingLot, String carName) {
        this.parkingLot = parkingLot;
        this.carName = carName;
    }

    public void run() {
        parkingLot.park(carName);
        try {
            Thread.sleep(2000);  // Simulate parking time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parkingLot.leave(carName);
    }
}