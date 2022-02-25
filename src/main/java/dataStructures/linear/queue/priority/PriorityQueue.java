package dataStructures.linear.queue.priority;

import java.util.Arrays;

public class PriorityQueue<T extends Number> {
    private T[] items;
    private int count;

    public PriorityQueue(int capacity) {
        this.items = (T[]) new Number[capacity];
    }

    public void add(T item) {
        if (isFull())
            throw new IllegalStateException();

        int position = shiftItemsToInsert(item);
        items[position] = item;
        count++;
    }

    private int shiftItemsToInsert(T item) {
        int position;
        for (position = count - 1; position >= 0; position--) {
            if (items[position].doubleValue() > item.doubleValue())
                items[position + 1] = items[position];
            else
                break;
        }
        return position+1;
    }

    public T remove() {
        if (isEmpty())
            throw new IllegalStateException();
        T item = items[--count];
        items[count] = null;
        return item;
    }


    public boolean isFull() {
        return count == items.length;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
