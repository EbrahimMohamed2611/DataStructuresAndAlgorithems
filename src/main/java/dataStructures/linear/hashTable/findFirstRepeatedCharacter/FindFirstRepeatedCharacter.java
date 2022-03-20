package dataStructures.linear.hashTable.findFirstRepeatedCharacter;

import java.util.HashSet;
import java.util.Set;

public class FindFirstRepeatedCharacter {

    public char findCharacter(String input){
        char[] characters = input.toCharArray();
        Set<Character> charactersSet = new HashSet<>();
        for (char ch: characters) {
            if(charactersSet.contains(ch))
                return ch;
            charactersSet.add(ch);
        }

        return Character.MIN_VALUE;
    }
}
