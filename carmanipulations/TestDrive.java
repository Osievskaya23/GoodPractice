package carmanipulations;

import carmanipulations.manager.CarManager;

import java.util.Scanner;

import static carmanipulations.manager.Constants.*;

public class TestDrive {
    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(CAR_CREATING_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        CarManager manager = new CarManager();
        Car car = manager.createNewCar(scanner.nextLine());
        if (car == null) return;

        System.out.println(CHECK_CAR_BEFORE_DRIVING);
        car = manager.checkCar(car);

        System.out.println(DRIVING);
        System.out.println(STOP_MESSAGE);
        manager.performDriving(car);
    }
}
