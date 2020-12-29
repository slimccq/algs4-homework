package exercise.chapter1;

// Exercise 1.3.32 以linked list实现的queue和stack
public class Steque<E>
{
    DoubleLinkedList list = null;
    private int n = 0;

    public Steque()
    {
        list = new DoubleLinkedList();
    }

    public boolean isEmpty()
    {
        return n == 0;
    }

    public int size()
    {
        return n;
    }

    // add item to tail
    public void push(E e)
    {
        DoubleLinkedList.LinkedNode node = new DoubleLinkedList.LinkedNode(e);
        list.insertTail(node);
        n++;
    }

    // pop tail item
    public E pop()
    {
        DoubleLinkedList.LinkedNode node = list.removeTail();
        n--;
        return (E)node.value;
    }

    // add item to head
    public void enqueue(E e)
    {
        DoubleLinkedList.LinkedNode node = new DoubleLinkedList.LinkedNode(e);
        list.insertHead(node);
        n++;
    }
}
