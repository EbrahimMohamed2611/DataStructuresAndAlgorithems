package algorithems.sort;

import java.util.Arrays;

public class InsertionSort {
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static <E extends Comparable<E>> void insertionSort(E[] arr) {
        for (int i = 1; i < arr.length; i++) { // will assume arr[0] the first element is sorted
            E current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(current) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] array = {4, 2, 10, -10, -5, 0, 2, 3, 6};
        Integer[] array2 = {4, 2, 10, -10, -5, 0, 2, 3, 6};
        insertionSort.sort(array);
        InsertionSort.insertionSort(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));
    }
}
