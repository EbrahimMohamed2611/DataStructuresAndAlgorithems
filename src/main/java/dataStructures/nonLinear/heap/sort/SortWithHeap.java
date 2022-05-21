package dataStructures.nonLinear.heap.sort;

import dataStructures.nonLinear.heap.Heap;

import java.util.Arrays;

public class SortWithHeap {
    public static void main(String[] args) {
        int[] numbers = {1,2,5,0,10,3,6,9};
        System.out.println(Arrays.toString(numbers));
        sortDesc(numbers);
        System.out.println(Arrays.toString(numbers));
        sortAsc(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void sortDesc(int[] numbers){
        Heap heap = new Heap(10);
        for (int number: numbers)
            heap.insert(number);

        // sort asc
        for (int i = 0; !heap.isEmpty(); i++) {
            numbers[i] = heap.remove();
        }
    }

    public static void sortAsc(int[] numbers){
        Heap heap = new Heap(10);
        for (int number: numbers)
            heap.insert(number);

        // sort asc
        for (int i = numbers.length-1; !heap.isEmpty(); --i) {
            numbers[i] = heap.remove();
        }
    }
}
