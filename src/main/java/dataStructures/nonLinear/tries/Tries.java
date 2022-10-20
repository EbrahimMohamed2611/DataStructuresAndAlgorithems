package dataStructures.nonLinear.tries;

import java.util.List;

public interface Tries {

    void insert(String word);
    boolean contains(String word);
    void traversPreOrder();
    void traversPostOrder();
    void remove(String word);
    List<String> findWords(String prefix);
}
