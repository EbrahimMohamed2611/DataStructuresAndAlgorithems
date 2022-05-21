package dataStructures.nonLinear.heap.priorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(10);
        queue.enqueue(10);
        queue.enqueue(2);
        queue.enqueue(30);
        queue.enqueue(5);
        queue.enqueue(15);
        queue.enqueue(40);
        queue.enqueue(100);
        while (!queue.isEmpty())
            System.out.println(queue.dequeue());
    }
}
