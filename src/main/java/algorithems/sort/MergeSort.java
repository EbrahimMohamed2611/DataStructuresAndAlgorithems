package algorithems.sort;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array.length < 2)
            return;

        int middle = array.length / 2;
        int[] left = new int[middle];
        for (int i = 0; i < middle; i++)
            left[i] = array[i];

        int[] right = new int[array.length - middle];
        for (int i = middle; i < array.length; i++)
            right[i - middle] = array[i];

        mergeSort(left);
        mergeSort(right);
        sort(left, right, array);

    }

    private static void sort(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] >= right[j])
                result[k++] = right[j++];
            else
                result[k++] = left[i++];
        }
        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 10, -10, -5, 0, 2, 3, 6}; // [-10, -5, 0, 2, 2, 3, 4, 6, 10]
        MergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
