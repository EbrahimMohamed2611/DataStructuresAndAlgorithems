package dataStructures.linear.stack.stringReverser;

import java.util.Stack;

public class StringReverser {
    private final String string;

    public StringReverser(String string) {
        this.string = string;
    }

    public String reverse() {
        if(string == null)
            throw new IllegalArgumentException();

        Stack<Character> characterStack = new Stack<>();
        char[] chars = string.toCharArray();
        for (Character character : chars) {
            characterStack.push(character);
        }
        StringBuilder reverseString = new StringBuilder();
        while (!characterStack.isEmpty()){
            reverseString.append(characterStack.pop());
        }
        return reverseString.toString();
    }

}
