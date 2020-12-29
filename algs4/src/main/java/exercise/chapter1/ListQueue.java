package exercise.chapter1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ListQueue<E> implements GeneralizedQueue<E> {
    private DoubleLinkedList list;
    private int N = 0;

    public ListQueue() {
        list = new DoubleLinkedList();
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void insert(E e) {
        DoubleLinkedList.LinkedNode node = new DoubleLinkedList.LinkedNode(e);
        list.insertTail(node);
        N++;
    }

    public E delete(int k) {
        if (k <= 0 || k > N) {
            return null;
        }
        DoubleLinkedList.LinkedNode node = list.sentinel;
        for(int i = 0; i < k; i++) {
            node = node.next;
        }
        if (node != null) {
            E v = (E)node.value;
            list.remove(node);
            N--;
            return v;
        }
        return null;
    }

    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E> {
        private DoubleLinkedList.LinkedNode node;

        public QueueIterator() {
            node = list.sentinel.next;
        }

        public boolean hasNext() {
            return node != null;
        }

        public E next() {
            E v = (E)node.value;
            node = node.next;
            return v;
        }
    }
}
