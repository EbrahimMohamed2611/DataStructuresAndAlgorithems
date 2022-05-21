package dataStructures.nonLinear.heap;


/**
 * Implement Max Binary Heap using Array
 */
public class Heap {
    private final int[] elements;
    private int size;

    public Heap() {
        elements = new int[10];
    }

    public Heap(int size) {
        elements = new int[size];
    }

    public void insert(int value) {
        if (isFull())
            throw new IllegalStateException("Heap is full");

        elements[size++] = value;
        bubbleUp();
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        int root = elements[0];
        elements[0] = elements[size - 1];
        elements[--size] = 0;
        // new to keep the Heap is valid
        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        int currentIndex = 0;
        while (currentIndex <= size - 1 && !isParentValid(currentIndex)) {
            // we need to choose the biggest one and swap it with current element
            int biggestChildIndex = largerChildIndex(currentIndex);
            swap(currentIndex, biggestChildIndex);
            currentIndex = biggestChildIndex;
        }
    }

    private boolean isParentValid(int index) {
        // check if no node in right
        if (!hasLeftChild(index))
            return true;

        if (!hasRightChild(index))
            return (elements[index] >= elements[leftChildIndex(index)]);

        return (elements[index] >= elements[leftChildIndex(index)] && elements[index] >= elements[rightChildIndex(index)]);
    }

    private int largerChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;

        if (!hasRightChild(index))
            return leftChildIndex(index);

        return (elements[leftChildIndex(index)] > elements[rightChildIndex(index)])
                ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasLeftChild(int parentIndex) {
        int leftChildIndex = leftChildIndex(parentIndex);
        return leftChildIndex < size;
    }

    private boolean hasRightChild(int parentIndex) {
        int rightChildIndex = rightChildIndex(parentIndex);
        return rightChildIndex < size;
    }

    private void bubbleUp() {
        int newElementIndex = size - 1;
        while (newElementIndex > 0 && elements[newElementIndex] > elements[parentIndex(newElementIndex)]) {
            swap(newElementIndex, parentIndex(newElementIndex));
            // update the new index for the new iteration
            newElementIndex = parentIndex(newElementIndex);
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = elements[firstIndex];
        elements[firstIndex] = elements[secondIndex];
        elements[secondIndex] = temp;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int parentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int leftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }
}
