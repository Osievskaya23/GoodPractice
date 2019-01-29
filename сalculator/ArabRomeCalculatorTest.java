package сalculator;

import java.util.Scanner;

public class ArabRomeCalculatorTest {
    public static void main(String[] args) {
        ArabRomeCalculator calculator = new ArabRomeCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter \"start\" to run");
        while (scanner.nextLine().equals("start")) {
            calculator.run();
        }
    }
}