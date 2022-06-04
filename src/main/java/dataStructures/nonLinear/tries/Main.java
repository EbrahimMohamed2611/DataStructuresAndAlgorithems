package dataStructures.nonLinear.tries;

import dataStructures.nonLinear.tries.impl.TriesWithHashTable;

public class Main {
    public static void main(String[] args) {
        Tries tries = new TriesWithHashTable();
        tries.insert("cat");
        tries.insert("can");
        tries.insert("add");
//        System.out.println(tries.contains("add"));
        tries.traversPreOrder();
        System.out.println();
        tries.traversPostOrder();
    }
}
