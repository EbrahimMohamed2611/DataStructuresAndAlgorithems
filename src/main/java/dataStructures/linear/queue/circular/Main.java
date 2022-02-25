package dataStructures.linear.queue.circular;

public class Main {
    public static void main(String[] args) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>(5);
        circularQueue.enqueue(1);
        circularQueue.enqueue(2);
        circularQueue.enqueue(3);
        circularQueue.enqueue(4);
        circularQueue.enqueue(5);
        System.out.println(circularQueue);
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        circularQueue.enqueue(40);
        circularQueue.enqueue(50);
        System.out.println(circularQueue);
    }
}
