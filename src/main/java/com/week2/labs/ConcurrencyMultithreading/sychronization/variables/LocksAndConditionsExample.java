package com.week2.labs.ConcurrencyMultithreading.sychronization.variables;

public class LocksAndConditionsExample {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(2);

        Car car1 = new Car(parkingLot, "Car 1");
        Car car2 = new Car(parkingLot, "Car 2");
        Car car3 = new Car(parkingLot, "Car 3");

        car1.start();
        car2.start();
        car3.start();
    }
}

