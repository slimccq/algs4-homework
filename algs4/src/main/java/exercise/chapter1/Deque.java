package exercise.chapter1;

import java.util.*;

// 链表实现的双向队列
public class Deque<E> implements Iterable<E>
{
    DoubleLinkedList list = new DoubleLinkedList();;
    private int n = 0;

    public Deque()
    {
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void pushLeft(E e)
    {
        DoubleLinkedList.LinkedNode node = new DoubleLinkedList.LinkedNode(e);
        list.insertHead(node);
        n++;
    }

    public void pushRight(E e)
    {
        DoubleLinkedList.LinkedNode node = new DoubleLinkedList.LinkedNode(e);
        list.insertTail(node);
        n++;
    }

    public E popLeft()
    {
        DoubleLinkedList.LinkedNode node = list.removeHead();
        n--;
        return (E)node.value;
    }

    public E popRight()
    {
        DoubleLinkedList.LinkedNode node = list.removeTail();
        n--;
        return (E)node.value;
    }

    public E first() {
        if (n == 0) {
            return null;
        }
        return (E)list.sentinel.next.value;
    }

    public E last() {
        if (n == 0) {
            return null;
        }
        return (E)list.last.value;
    }

    @Override
    public Iterator<E> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<E> {
        private DoubleLinkedList.LinkedNode node = list.sentinel;

        @Override
        public boolean hasNext() { return node.next != null; }

        @Override
        public E next() {
            node = node.next;
            return (E)node.value;
        }
    }
}
