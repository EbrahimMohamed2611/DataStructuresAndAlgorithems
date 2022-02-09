package dataStructures.linear.stack.stringReverser;

public class Main {
    public static void main(String[] args) {
        StringReverser stringReverser = new StringReverser("Hello");
//        StringReverser stringReverser = new StringReverser(null);
        String reverse = stringReverser.reverse();
        System.out.println(reverse);
    }
}
