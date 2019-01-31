package com.calculator;

import java.util.Scanner;

public class ArabRomeCalculatorApp {
    public static void main(String[] args) {
        ArabRomeCalculator calculator = new ArabRomeCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter \"start\" to run");
        while (scanner.nextLine().equals("start")) {
            calculator.run();
        }
    }
}
