package manager;

import static manager.Constants.AMOUNT_ERROR;
import static manager.Constants.ERROR;
import static manager.Constants.SORTING_ERROR;

public class Manager {
    /**
     * print array of int in console
     * @param arr array, you need to print
     */
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    /**
     * Create new array of int and fill it with values, converted from String to int
     * @param arrayLength length of new array
     * @param secondInput array of Strings with values
     * @return new array of int
     */
    public static int[] createArray(int arrayLength, String[] secondInput) {
        int[] arr = new int[arrayLength];
        for (int i = 0; i < secondInput.length; i++) {
            arr[i] = Integer.parseInt(secondInput[i]);
        }
        //if (isSorted(arr)) return arr;
        return arr;
    }

    /**
     * Check is sorted or no
     * @param arr checked array
     * @return true if array is sorted else false
     */
    public static boolean isSorted(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (Integer.parseInt(arr[i]) > Integer.parseInt(arr[i + 1])) {
                System.out.println(ERROR + SORTING_ERROR);
                return false;
            }
        }
        return true;
    }

    public static boolean amountIsEqualLength(int amount, int length) {
        if (amount != length) {
            System.out.println(ERROR + AMOUNT_ERROR);
            return false;
        }
        return true;
    }
}
