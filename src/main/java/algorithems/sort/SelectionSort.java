package algorithems.sort;

import java.util.Arrays;

public class SelectionSort {
    /**
     * O(n^2) as the worst case
     *
     * @param array unsorted
     */
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++)
                if (array[j] < array[minIndex])
                    minIndex = j;

            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

        }
    }

    public static <E extends Comparable<E>> void selectionSort(E[] array){
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if(array[j].compareTo(array[minIndex]) < 0)
                    minIndex = j;
            }
            E temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] array = {4, 2, 10, -10, -5, 0, 2, 3, 6};
        Integer[] array2 = {4, 2, 10, -10, -5, 0, 2, 3, 6};
        selectionSort.sort(array);
        SelectionSort.selectionSort(array2);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(array2));

    }

}
