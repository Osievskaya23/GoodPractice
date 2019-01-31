package com.carmanipulations;

import static com.carmanipulations.manager.Constants.CAR_INFORMATION_TITLE;
import static com.carmanipulations.manager.Constants.DOWN_LINE;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.stream.Stream;

public class Car {
    private final Calendar dateOfManufacture;
    private String enginesType;
    private double maxSpeed;
    private double accelerationTime;
    private int passengerCapacity;
    private int currentAmountOfPassengers;
    private double currentSpeed;
    private CarDoor[] carDoors;
    private CarWheel[] carWheels;

    public Car(Calendar dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
        this.enginesType = "type";
        this.maxSpeed = 100_000;
        this.accelerationTime = 1;
        this.passengerCapacity = 2;
        this.carWheels = new CarWheel[]{};
        this.carDoors = new CarDoor[]{};
    }

    public Car(Calendar dateOfManufacture, String enginesType, double maxSpeed,
               double accelerationTime, int passengerCapacity) {
        this.dateOfManufacture = dateOfManufacture;
        this.enginesType = enginesType;
        this.maxSpeed = maxSpeed;
        this.accelerationTime = accelerationTime;
        this.passengerCapacity = passengerCapacity;
        this.carWheels = new CarWheel[]{};
        this.carDoors = new CarDoor[]{};
    }

    public void changeCurrentSpeed(double newSpeed) {
        currentSpeed = newSpeed;
        System.out.println("Current speed = " + currentSpeed);
    }

    public void addPassenger() {
        currentAmountOfPassengers++;
        System.out.println("Passenger was added.");
    }

    public void removePassenger() {
        currentAmountOfPassengers--;
        System.out.println("Passenger was removed.");
    }

    public void removeAllPassengers() {
        currentAmountOfPassengers = 0;
        System.out.println("All passengers were removed.");
    }

    public CarDoor getCarDoor(int index) {
        return carDoors[index];
    }

    public CarWheel getCarWheel(int index) {
        return carWheels[index];
    }

    public void takeOffAllWhells() {
        Arrays.fill(carWheels, null);
        System.out.println("All wheels were taken off.");
    }

    public void addAllWheels(int amount) {
        CarWheel[] newCarWheels = new CarWheel[amount];
        for (int i = 0; i < amount; i++) {
            newCarWheels[i] = new CarWheel();
        }
        carWheels = Stream.concat(Arrays.stream(carWheels), Arrays.stream(newCarWheels))
                .toArray(CarWheel[]::new);
    }

    public double calculateCurrantPossibleMaxSpeed() {
        if (currentAmountOfPassengers == 0)
            return 0;
        else {
            return maxSpeed * getOldestCarWheel().getIntegrityStatus();
        }
    }

    private CarWheel getOldestCarWheel() {
        CarWheel oldestCarWheel = carWheels[0];
        for (CarWheel wheel : carWheels) {
            if (wheel.getIntegrityStatus() < oldestCarWheel.getIntegrityStatus())
                oldestCarWheel = wheel;
        }
        return oldestCarWheel;
    }

    public void showCarInfo() {
        System.out.println(CAR_INFORMATION_TITLE);
        String data = (new SimpleDateFormat("dd.mm.yyyy")).format(dateOfManufacture.getTime());
        System.out.printf("\n%-30S : %s", "date of manufacture", data);
        System.out.printf("\n%-30S : %s", "engines type", enginesType);
        System.out.printf("\n%-30S : %s", "max speed", maxSpeed);
        System.out.printf("\n%-30S : %s", "acceleration time", accelerationTime);
        System.out.printf("\n%-30S : %s", "passenger capacity", passengerCapacity);
        System.out.printf("\n%-30S : %s", "current amount of passengers", currentAmountOfPassengers);
        System.out.printf("\n%-30S : %s", "current speed", currentSpeed);
        for (int i = 0; i < carWheels.length; i++) {
            System.out.printf("\n%-30S : %-10s", "wheel_" + (i + 1), carWheels[i].showInfo());
        }
        System.out.println(DOWN_LINE);
    }

    public void setCarDoors(CarDoor[] carDoors) {
        this.carDoors = carDoors;
    }
}
