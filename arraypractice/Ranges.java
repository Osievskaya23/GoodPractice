import static manager.Constants.RANGES;
import static manager.Constants.ENTER_ARRAY_SIZE;
import static manager.Constants.ENTER_ARRAY_VALUES;
import static manager.Constants.EXAMPLE_THREE;
import static manager.Manager.amountIsEqualLength;
import static manager.Manager.createArray;
import static manager.Manager.isSorted;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ranges {
    static void ranges() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(RANGES + ENTER_ARRAY_SIZE);

        int arrLength = Integer.parseInt(scanner.nextLine());

        System.out.println(ENTER_ARRAY_VALUES + EXAMPLE_THREE);

        String[] values = scanner.nextLine().split(" ");

        if(!amountIsEqualLength(arrLength, values.length) || !isSorted(values)) return;

        System.out.println(findRanges(createArray(arrLength, values)));
    }

    private static StringBuilder findRanges(int[] array) {
        StringBuilder result = new StringBuilder();
        List<Integer> tmpList = new ArrayList<>();
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] + 1 == array[i + 1]) {
                tmpList.add(array[i]);
            } else {
                tmpList.add(array[i]);
                result.append(addArray(tmpList));
                tmpList.clear();
            }
        }
        tmpList.add(array[array.length - 1]);
        result.append(addArray(tmpList));
        return result;
    }

    private static String addArray(List<Integer> list) {
        if (list.size() == 1) return "[" + list.get(0) + "]";
        return "[" + getMin(list) + " " + getMax(list) + "]";
    }

    private static int getMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i : list) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }

    private static int getMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int i : list) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
}
