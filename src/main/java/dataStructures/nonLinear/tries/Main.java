package dataStructures.nonLinear.tries;

import dataStructures.nonLinear.tries.impl.TriesArrayImpl;
import dataStructures.nonLinear.tries.impl.TriesWithHashTable;

public class Main {
    public static void main(String[] args) {
        Tries tries = new TriesWithHashTable();
        tries.insert("cat");
        tries.insert("can");
        tries.insert("add");
        tries.insert("adder");
        System.out.println(tries.contains("add"));
//        tries.remove("add");
//        tries.remove("adder");
        System.out.println(tries.contains("add"));
        System.out.println(tries.contains("adder"));
//        tries.traversPreOrder();
        System.out.println(tries.findWords("c"));
//        tries.traversPostOrder();


//        Tries trie = new TriesArrayImpl();
//        trie.insert("cat");
//        trie.insert("can");
//        trie.insert("add");
//        System.out.println(trie.contains("add"));
//        System.out.println(trie.contains("can"));
//        System.out.println(trie.contains("cans"));
//        trie.traversPreOrder();
//        System.out.println();
//        trie.traversPostOrder();



    }
}
