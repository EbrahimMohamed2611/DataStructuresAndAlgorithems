package dataStructures.nonLinear.tries;

public interface Tries {

    void insert(String word);
    boolean contains(String word);
    void traversPreOrder();
    void traversPostOrder();
}
