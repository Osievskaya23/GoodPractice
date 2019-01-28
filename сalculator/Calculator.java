package сalculator;

import java.util.Scanner;

class Calculator {
    void run() {
        double[] numbers = new double[2];
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        String value1 = scanner.nextLine();
        numbers[0] = (isDecimal(value1) ? Double.parseDouble(value1) : getDecimalNumber(value1));

        System.out.print("Enter second number: ");
        String value2 = scanner.nextLine();
        numbers[1] = (isDecimal(value2) ? Double.parseDouble(value2) : getDecimalNumber(value2));

        if (!numbersAreTheDifferentType(value1, value2))
            calculate(numbers[0], numbers[1]);
        else
            System.out.println("Number have to be the same type!");
    }

    private void calculate(double value1, double value2) {
        System.out.print("Enter operation: ");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "+":
                System.out.println(value1 + " + " + value2 + " = " + (value1 + value2));
                break;
            case "-":
                System.out.println(value1 + " - " + value2 + " = " + (value1 - value2));
                break;
            case "*":
                System.out.println(value1 + " * " + value2 + " = " + (value1 * value2));
                break;
            case "/":
                System.out.println(value1 + " / " + value2 + " = " + (value1 / value2));
                break;
            default:
                System.out.println("Illegal input");

        }
    }

    private double getDecimalNumber(String number) {
        double result = 0;
        String[] symbolArray = number.split("");
        for (int i = 0; i < symbolArray.length - 1; i++) {
            if (getValue(symbolArray[i]) <= getValue(symbolArray[i + 1]))
                result += getValue(symbolArray[i]);
            else
                result = result + getValue(symbolArray[i + 1]) - getValue(symbolArray[i]);
        }
        result += getValue(symbolArray[symbolArray.length - 1]);
        return result;
    }

    private boolean numbersAreTheDifferentType(String value1, String value2) {
        return (isDecimal(value1) && isDecimal(value2));
    }

    private boolean isDecimal(String value1) {
        return value1.matches("-*[0-9]+.*[0-9]+|[0-9]+");
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
    private double getValue(String n) {
        if (n.equals("I"))
            return 1;
        if (n.equals("V"))
            return 5;
        if (n.equals("X"))
            return 10;
        if (n.equals("L"))
            return 50;
        if (n.equals("C"))
            return 100;
        if (n.equals("D"))
            return 500;
        if (n.equals("M"))
            return 1000;
        return -1;
    }
}

class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter \"start\" to run");
        while (scanner.nextLine().equals("start")) {
            calculator.run();
        }
    }
}