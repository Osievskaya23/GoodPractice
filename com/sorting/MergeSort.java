package com.sorting;

public class MergeSort {
    private static void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        int secondLeft = middleIndex + 1;
        if (array[middleIndex] <= array[secondLeft]) { return; }
        while (leftIndex <= middleIndex && secondLeft <= rightIndex ) {
            if (array[leftIndex] <= array[secondLeft]) {
                leftIndex++;
            } else {
                int value = array[middleIndex + 1];
                int index = middleIndex + 1;
                while (index != leftIndex) {
                    array[index] = array[index - 1];
                    index--;
                }
                array[leftIndex] = value;

                leftIndex++;
                middleIndex++;
                secondLeft++;
            }
        }
    }

    public static void sort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = leftIndex + ((rightIndex - leftIndex) / 2);
            sort(array, leftIndex, middleIndex);
            sort(array, middleIndex + 1, rightIndex);
            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }
}
