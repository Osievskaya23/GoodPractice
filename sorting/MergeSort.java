package sorting;

class MergeSort {
    private static void merge(int[] array, int[] left, int[]right, int leftLength, int rightLength) {
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength){
            if (left[i] <= right[j])
                array[k++] = left[i++];
            else
                array[k++] = right[j++];
        }
        while (i < leftLength) {
            array[k++] = left[i++];
        }
        while (j < rightLength) {
            array[k++] = right[j++];
        }
    }

    static void sort(int[] array, int length) {
        if (length < 2) return;

        int middle = length / 2;
        int[] left = new int[middle];
        int[] right = new int[length - middle];
        System.arraycopy(array, 0, left, 0, middle);
        if (length - middle >= 0) {
            System.arraycopy(array, middle, right, 0, length - middle);
        }
        sort(left, middle);
        sort(right, length - middle);
        merge(array, left, right, middle, length - middle);
    }
}

class Test {
    public static void main(String[] args) {
        int[] array1 = {18, 5, 4, 3, 25, 17};
        int[] array2 = {20, 5, 107, 8, 45, 23, 34, 98, 12};
        int[] array3 = {21, 40, 56, 5, 19, 18, 7, 19, 147, 248, 34};

        System.out.println("Before");
        printArray(array1);
        printArray(array2);
        printArray(array3);

        MergeSort.sort(array1, array1.length);
        MergeSort.sort(array2, array2.length);
        MergeSort.sort(array3, array3.length);

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
