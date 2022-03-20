package dataStructures.linear.hashTable.findFirstNonRepeatedCharacter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonRepeatedCharacter {

    public char findFirstNonRepeatingCharacter(String input) {
        Map<Character, Integer> map = new HashMap<>();
//        Map<Character, Integer> map = new LinkedHashMap<>();
        char[] characters = input.toCharArray();
        for (char ch : characters) {
            int counter = map.containsKey(ch) ? (map.get(ch) + 1) : 1;
            map.put(ch, counter);
        }

        for (char ch : characters) {
            if (map.get(ch) == 1)
                return ch;
        }
        System.out.println(map);
        return Character.MIN_VALUE;
    }
}
