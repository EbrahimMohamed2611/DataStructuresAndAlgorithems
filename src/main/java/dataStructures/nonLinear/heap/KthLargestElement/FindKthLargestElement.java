package dataStructures.nonLinear.heap.KthLargestElement;

import dataStructures.nonLinear.heap.Heap;

public class FindKthLargestElement {
    public static int getKthLargestElement(int[] numbers, int k) {
        if (k < 1 || k > numbers.length)
            throw new IllegalArgumentException();

        final Heap heap = new Heap();
        for (int number : numbers)
            heap.insert(number);

        for (int i = 0; i < k - 1; i++)
            heap.remove();

        return max(heap);
    }

    private static int max(final Heap heap) {
        return heap.remove();
    }
}
