package algorithems.sort;

import java.util.Arrays;

public class BubbleSort {

    /**
     * O(n^2) as the worst case
     *
     * @param array
     */
    public void sort(int[] array) {
        boolean isSorted;
        for (int i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j] < array[j - 1]) {
                    isSorted = false;
                    swap(array, j);
                }
            }
            if (isSorted)
                return;
        }
    }

    public static <E extends Comparable<E>> void bubbleSort(E[] array) {
        boolean isSorted;
        for (int i = 0; i < array.length; i++) {
            isSorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j-1].compareTo(array[j]) > 0) {
                    E temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) return;
        }
    }

    private void swap(int[] array, int j) {
        int temp = array[j];
        array[j] = array[j - 1];
        array[j - 1] = temp;
    }


    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {4, 2, 10, -10, -5, 0, 2, 3, 6};
        Integer[] array2 = {4, 2, 10, -10, -5, 0, 2, 3, 6};
        bubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
        BubbleSort.bubbleSort(array2);
        System.out.println(Arrays.toString(array2));

    }
}
