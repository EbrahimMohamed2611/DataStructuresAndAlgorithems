package dataStructures.nonLinear.heap.heapify;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1,5,12,6,9,3,69,24,0,50, 100, 68};
        Heapify.heapify(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}
