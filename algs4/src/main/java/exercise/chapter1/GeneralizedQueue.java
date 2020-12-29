package exercise.chapter1;

public interface GeneralizedQueue<E> extends Iterable<E> {

    // count of queue elements
    int size();

    // is queue empty
    boolean isEmpty();

    // insert an element
    void insert(E e);

    // delete k-th element, k ∈ [1,N]
    E delete(int k);
}
