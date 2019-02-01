package com.sorting;

class Test {
    public static void main(String[] args) {
        int[] array1 = {12, 11, 13, 5, 6, 7};
        int[] array2 = {20, 5, 107, 8, 45, 23, 34, 98, 12};
        int[] array3 = {21, 40, 56, 5, 19, 18, 7, 19, 147, 248, 34};

        System.out.println("Before");
        printArray(array1);
        printArray(array2);
        printArray(array3);

        MergeSort.sort(array1, 0, array1.length - 1);
        MergeSort.sort(array2, 0, array2.length - 1);
        MergeSort.sort(array3, 0, array3.length - 1);

        System.out.println("After");
        printArray(array1);
        printArray(array2);
        printArray(array3);
    }

    private static void printArray(int[] array) {
        StringBuilder string = new StringBuilder("[");
        for (int i : array) {
            string.append(i).append(" ");
        }
        System.out.println(string.append("]"));
    }
}
