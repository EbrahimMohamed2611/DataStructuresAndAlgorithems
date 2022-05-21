package dataStructures.nonLinear.heap.priorityQueue;

import dataStructures.nonLinear.heap.Heap;

public class PriorityQueue {
    private Heap heap;

    public PriorityQueue() {
        heap = new Heap(10);
    }

    public PriorityQueue(int size) {
        heap = new Heap(size);
    }

    public void enqueue(int item) {
        heap.insert(item);
    }

    public int dequeue() {
        return heap.remove();
    }

    public boolean isFull() {
        return heap.isFull();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
