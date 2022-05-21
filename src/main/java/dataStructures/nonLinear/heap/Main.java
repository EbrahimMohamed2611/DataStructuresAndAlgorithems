package dataStructures.nonLinear.heap;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(20);
        heap.insert(4);
        System.out.println(heap.remove());
//        heap.insert(12);
//        heap.insert(50);
//        heap.insert(3);
//        heap.insert(1);
//        heap.insert(16);
//        heap.insert(6);
//        heap.insert(60);
        System.out.println("Done..");
    }
}
