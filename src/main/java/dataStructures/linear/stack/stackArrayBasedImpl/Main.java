package dataStructures.linear.stack.stackArrayBasedImpl;

public class Main {
    public static void main(String[] args) {
        StackArrayBased<Integer> numbers = new StackArrayBased<>(5);
        numbers.push(5);
        numbers.push(10);
        numbers.push(8);

        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
        System.out.println(numbers.pop());
        numbers.push(5);
        numbers.push(10);
        numbers.push(8);
        System.out.println(numbers.peek());


        System.out.println(numbers);
        numbers.clear();
        System.out.println(numbers.pop());

    }
}
