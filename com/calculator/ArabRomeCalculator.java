package com.calculator;

import java.util.Scanner;

public class ArabRomeCalculator {

    public void run() {
        double[] numbers = new double[2];
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        String value1 = scanner.nextLine();
        numbers[0] = (isDecimal(value1) ? Double.parseDouble(value1) : getDecimalNumber(value1));

        System.out.print("Enter operation: ");
        String operation = scanner.nextLine();

        System.out.print("Enter second number: ");
        String value2 = scanner.nextLine();
        numbers[1] = (isDecimal(value2) ? Double.parseDouble(value2) : getDecimalNumber(value2));

        if (numbersAreOfDifferentType(value1, value2)) {
            System.out.println("Number have to be the same type!");
            return;
        }
        double result = calculate(numbers[0], operation, numbers[1]);
        System.out.print(value1 + " " + operation + " " + value2 + " = ");
        System.out.println(isDecimal(value1) ? result: getRomeNumber(result));
    }

    private double calculate(double value1, String operation, double value2) {
        switch (operation) {
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            case "/":
                return value1 / value2;
            default:
                System.out.println("Illegal input");
                return 0;
        }
    }

    private double getDecimalNumber(String number) {
        double result = 0;
        final int len = number.length();
        for (int i = 0; i < len - 1; i++) {
            if (getValue(number.charAt(i)) >= getValue(number.charAt(i + 1)))
                result += getValue(number.charAt(i));
            else
                result = result + getValue(number.charAt(i + 1)) - getValue(number.charAt(i));
        }
        result += getValue(number.charAt(len - 1));
        return result;
    }

    private StringBuilder getRomeNumber(double n) {
        int number = (int)n;
        if  (number <= 0) {
            System.out.println("Number couldn't be negative!");
            return new StringBuilder();
        }
        StringBuilder result = new StringBuilder();
        if (number >= 1000) {
            result.append(getRomeNumberPart("M", number/1000));
            number %= 1000;
        }
        if (number >= 500 && number < 900) {
            result.append(getRomeNumberPart("D", number/500));
            number %= 500;
        }
        if (number >= 500) {
            result.append("CM");
            number %= 100;
        }
        if (number >= 100 && number < 400) {
            result.append(getRomeNumberPart("C", number/100));
            number %= 100;
        }
        if (number >= 100) {
            result.append("CD");
            number %= 100;
        }
        if (number >= 50 && number < 90) {
            result.append(getRomeNumberPart("L", number/50));
            number %= 50;
        }
        if (number >= 50) {
            result.append("XC");
            number %= 50;
        }
        if (number >= 10 && number < 40) {
            result.append(getRomeNumberPart("X", number/10));
            number %= 10;
        }
        if (number >= 10) {
            result.append("XL");
            number %= 10;
        }
        if (number >= 5 && number < 9) {
            result.append(getRomeNumberPart("V", number / 5));
            number %= 5;
        }
        if (number >= 5) {
            result.append("V");
            number %= 5;
        }
        if (number >= 1 && number < 4) {
            result.append(getRomeNumberPart("I", number));
            number = 0;
        }
        if (number >= 1) {
            result.append("IV");
        }
        return result;
    }

    private StringBuilder getRomeNumberPart(String symbol, int amountOfSymbols) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < amountOfSymbols; i++) {
            result.append(symbol);
        }
        return result;
    }

    private boolean numbersAreOfDifferentType(String value1, String value2) {
        return (isDecimal(value1) ^ isDecimal(value2));
    }

    private boolean isDecimal(String value) {
        return value.matches("-*[0-9]+.*[0-9]+|[0-9]+");
    }

    /**
     *   I  - 1
     *   IV - 4
     *   V  - 5
     *   IX - 9
     *   X  - 10
     *   XL - 40
     *   L  - 50
     *   XC - 90
     *   C  - 100
     *   CD - 400
     *   D  - 500
     *   CM - 900
     *   M  - 1000
     */
    private int getValue(char symbol) {
        if (symbol == 'I') { return 1; }
        if (symbol == 'V') { return 5; }
        if (symbol == 'X') { return 10; }
        if (symbol == 'L') { return 50; }
        if (symbol == 'C') { return 100; }
        if (symbol == 'D') { return 500; }
        if (symbol == 'M') { return 1000; }
        return -1;
    }
}
