package com.carmanipulations.manager;

import com.carmanipulations.Car;
import com.carmanipulations.CarDoor;

import java.util.Calendar;
import java.util.Scanner;

public class CarManager {
    public Car createNewCar(String creatingMethod) {
        switch (creatingMethod) {
            case "new" :
                return createNewCar();
            case "default" :
                return createDefaultCar();
            default:
                System.out.println("Wrong creating method!");
                return null;
        }
    }

    private Car createDefaultCar() {
        System.out.println(Constants.ENTER_CAR_DATE_OF_MANUFACTURE);
        Scanner scanner = new Scanner(System.in);
        Car car = new Car(getData(scanner.nextLine().split("/")));
        return addDefaultWheelsAndDoors(car);
    }

    private Car createNewCar() {
        System.out.println(Constants.ENTER_CAR_PARAMETERS);
        Scanner scanner = new Scanner(System.in);
        String[] carParameters = scanner.nextLine().split(", ");
        Car car = new Car(getData(carParameters[0].split("/")), carParameters[1],
                Double.parseDouble(carParameters[2]), Double.parseDouble(carParameters[3]),
                Integer.parseInt(carParameters[4]));
        return addDefaultWheelsAndDoors(car);
    }

    private Car addDefaultWheelsAndDoors(Car car) {
        car.addAllWheels(4);
        car.setCarDoors(new CarDoor[] {new CarDoor(), new CarDoor(), new CarDoor(), new CarDoor()});
        return car;
    }

    private Calendar getData(String[] data) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(data[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(data[1]));
        cal.set(Calendar.YEAR, Integer.parseInt(data[2]));
        return cal;
    }

    public Car checkCar(Car car) {
        car.showCarInfo();
        System.out.println(Constants.GET_CHANGES);

        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("need changes")) {
            System.out.println(Constants.CHANGES_LIST);
            String command;
            while (!(command = scanner.nextLine()).equals("ok")) {
                car = getChanges(car, command);
            }
        }
        return car;
    }

    private Car getChanges(Car car, String command) {
        Scanner scanner = new Scanner(System.in);
        switch (command) {
            case "1":
                System.out.print("Enter new speed: ");
                car.changeCurrentSpeed(scanner.nextDouble());
                break;
            case "2" :
                car.addPassenger();
                break;
            case "3":
                car.removePassenger();
                break;
            case "4":
                car.removeAllPassengers();
                break;
            case "5":
                car.takeOffAllWhells();
                break;
            case "6":
                System.out.print("Enter number of wheel, you want to change: ");
                car.getCarWheel(scanner.nextInt()).changeWheel();
                break;
            case "7":
                System.out.print("Enter number of wheel and percent of wiping (1, 25%): ");
                String[] input = scanner.nextLine().split(", ");
                car.getCarWheel(Integer.parseInt(input[0]))
                        .wipeWheel(Integer.parseInt(input[1].substring(0, (input[1].length() - 1))));
                car.getCarWheel(Integer.parseInt(input[0])).showInfo();
                break;
            case "8":
                System.out.println("Current possible mas speed = "
                        + car.calculateCurrantPossibleMaxSpeed());
                break;
            case "9":
                car.showCarInfo();
                break;
        }
        return car;
    }

    public void performDriving(Car car) {
        Scanner scanner = new Scanner(System.in);
        String command;
        while (!(command = scanner.nextLine()).equals("stop")) {
            switch (command) {
                case "1":
                    System.out.print("Enter number of door: ");
                    car.getCarDoor(scanner.nextInt()).openDoor();
                    break;
                case "2":
                    System.out.print("Enter number of door: ");
                    car.getCarDoor(scanner.nextInt()).closeDoor();
                    break;
                case "3":
                    System.out.print("Enter number of window: ");
                    car.getCarDoor(scanner.nextInt()).openWindow();
                    break;
                case "4":
                    System.out.print("Enter number of window: ");
                    car.getCarDoor(scanner.nextInt()).closeWindow();
                    break;
                case "5":
                    System.out.print("Enter number of door: ");
                    car.getCarDoor(scanner.nextInt()).openCloseDoor();
                    break;
                case "6":
                    System.out.print("Enter number of window: ");
                    car.getCarDoor(scanner.nextInt()).openCloseWindow();
                    break;
                case "7":
                    System.out.print("Enter number of door: ");
                    car.getCarDoor(scanner.nextInt()).getDoorStatus();
                    break;
                case "8":
                    System.out.print("Enter number of window: ");
                    car.getCarDoor(scanner.nextInt()).getWindowStatus();
                    break;
            }
        }
    }
}
