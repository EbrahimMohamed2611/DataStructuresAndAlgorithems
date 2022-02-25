package dataStructures.linear.queue.circular;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class CircularQueue<T> {

    private final T[] items;
    private int front;
    private int rear;
    private int counter;

    public CircularQueue(int capacity) {
        items = (T[]) new Object[capacity];
    }

    public void enqueue(T item) {
        if (isFull())
            throw new IllegalStateException();
        items[rear] = item;
        rear = (rear + 1) % items.length;
        counter++;

    }

    public T dequeue() {
        if (isEmpty())
            throw new NoSuchElementException();
        T item = items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        counter--;
        return item;

    }

    public boolean isFull() {
        return counter == items.length;
    }

    public boolean isEmpty() {
        return (counter - 1) < 0;
    }

    @Override
    public String toString() {
        return "CircularQueue{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
