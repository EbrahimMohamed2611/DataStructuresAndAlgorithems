package dataStructures.linear.hashTable.findFirstNonRepeatedCharacter;

public class Main {
    public static void main(String[] args) {
        String name = "a green apple";
        // 'a' => 2
        // ' ' => 2
        // 'g' => 1

        FindFirstNonRepeatedCharacter characterFinder = new FindFirstNonRepeatedCharacter();
        char firstNonRepeatingCharacter = characterFinder.findFirstNonRepeatingCharacter(name);
        System.out.println(firstNonRepeatingCharacter);
    }
}
