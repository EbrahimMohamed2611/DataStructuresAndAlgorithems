package dataStructures.nonLinear.heap.heapify;

public class Heapify {

    public static void heapify(int[] numbers) {
        for (int i = numbers.length / 2 - 1; i >= 0; i--)
            heapify(numbers, i);

    }

    private static void heapify(int[] arr, int index) {
        // First we assume the current index is large index
        int largeIndex = index;

        int leftIndex = leftChildIndex(index);
        if (leftIndex < arr.length && arr[leftIndex] > arr[largeIndex])
            largeIndex = leftIndex;

        int rightIndex = rightChildIndex(index);
        if (rightIndex < arr.length && arr[rightIndex] > arr[largeIndex])
            largeIndex = rightIndex;

        if (largeIndex == index)
            return;

        swap(arr, index, largeIndex);
        // So, we need to repeat the above logic until the current value put it in the perfect place
        heapify(arr, largeIndex);

    }

    private static void swap(int[] arr, int index, int largeIndex) {
        int temp = arr[index];
        arr[index] = arr[largeIndex];
        arr[largeIndex] = temp;
    }

    private static int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private static int rightChildIndex(int index) {
        return index * 2 + 2;
    }

}
