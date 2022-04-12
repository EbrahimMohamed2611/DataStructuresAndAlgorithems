package algorithems.sort;

import java.util.Arrays;

public class InsertionSort {
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] array = {4, 2, 10, -10, -5, 0, 2, 3, 6};
        insertionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
