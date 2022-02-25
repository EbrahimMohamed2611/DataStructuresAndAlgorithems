package dataStructures.linear.queue.standard;

public class Main {
    public static void main(String[] args) {
        StandardQueue<Integer> numbers = new StandardQueue<>(5);
        numbers.enqueue(1);
        numbers.enqueue(2);
        numbers.enqueue(3);
        System.out.println(numbers);
        System.out.println(numbers.dequeue());
        System.out.println(numbers.dequeue());
        System.out.println(numbers.dequeue());
        numbers.enqueue(20);
        numbers.enqueue(30);
        numbers.enqueue(40);
        System.out.println(numbers);
    }
}
