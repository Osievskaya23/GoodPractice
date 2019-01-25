import static manager.Constants.ARRAY_ROTATION;
import static manager.Constants.ENTER_ARRAY_SIZE_AND_K;
import static manager.Constants.ERROR;
import static manager.Constants.INCORRECT_INPUT;
import static manager.Constants.SHIFT_ERROR;
import static manager.Constants.ENTER_ARRAY_VALUES;
import static manager.Constants.EXAMPLE_ONE;
import static manager.Manager.amountIsEqualLength;
import static manager.Manager.printArray;
import static manager.Manager.createArray;

import java.util.Scanner;

public class ArrayRotation {

    static void arrayRotation() {
        System.out.println(ARRAY_ROTATION + ENTER_ARRAY_SIZE_AND_K);

        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" "); // massive size and shift length

        if (!ensureTwoNumbersEntered(firstInput.length)) return;

        int arrayLength = Integer.parseInt(firstInput[0]);
        int shiftLength = Integer.parseInt(firstInput[1]);

        if (!shiftSmallerThanArray(arrayLength, shiftLength)) return;

        System.out.println(ENTER_ARRAY_VALUES + EXAMPLE_ONE);

        String[] secondInput = scanner.nextLine().split(" ");

        if (!amountIsEqualLength(secondInput.length, arrayLength)) return;

        int[] arr = createArray(arrayLength, secondInput);

        printArray(shift(arr, shiftLength));
    }

    private static boolean ensureTwoNumbersEntered (int amountOfNumbers) {
        if (amountOfNumbers != 2) {
            System.out.println(ERROR + INCORRECT_INPUT);
            return false;
        }
        return true;
    }

    private static boolean shiftSmallerThanArray(int arrayLength, int shiftLength) {
        if (arrayLength < shiftLength && arrayLength > 0) {
            System.out.println(ERROR + SHIFT_ERROR);
            return false;
        }
        return true;
    }

    private static int[] shift(int[] arr, int k) {
        int[] resultArr = new int[arr.length];
        if (resultArr.length - k >= 0) {
            System.arraycopy(arr, k, resultArr, 0, resultArr.length - k);
        }
        if (k >= 0) {
            System.arraycopy(arr, 0, resultArr, resultArr.length - k, k);
        }
        return resultArr;
    }
}
