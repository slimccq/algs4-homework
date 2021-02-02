package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.CircularList;

import java.util.Iterator;

// circular list实现queue
public class Exercise29_Queue {
    public static void main(String[] args)
    {
        Queue<Integer> que = new Queue<>();
        for (int i = 0; i < 10; i++) {
            que.enqueue(i);
        }
        for (int n : que) {
            StdOut.printf("%d ", n);
        }
        StdOut.println();
        for (int i = 0; i < 10; i++) {
            int n = que.dequeue();
            StdOut.printf("%d ", n);
        }
        StdOut.println();
    }

    public static class Queue<E> implements Iterable<E>
    {
        private CircularList list = new CircularList();

        public Queue() {}

        public int size() {
            return list.size();
        }

        public void enqueue(E v) {
            CircularList.ListNode node = new CircularList.ListNode(v);
            list.insertTail(node);
        }

        public E dequeue() {
            CircularList.ListNode node = list.removeHead();
            return (E)node.value;
        }

        public E top() {
            return (E)list.first.value;
        }

        public Iterator<E> iterator() {
            return new QueueIterator();
        }

        private class QueueIterator implements Iterator<E> {
            private CircularList.ListNode node = null;
            private CircularList.ListNode prev = null;

            public QueueIterator() {
                node = list.first;
            }

            public boolean hasNext() {
                return node != null && prev != list.last;
            }

            public E next() {
                E v = (E)node.value;
                prev = node;
                node = node.next;
                return v;
            }
        }
    }
}