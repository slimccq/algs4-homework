package exercise.chapter1;

// 单链表
public class LinkedList<E>
{
    public static class LinkedNode<E> {
        public LinkedNode next = null;
        public E value;

        public LinkedNode(E value) {
            this.value = value;
        }

        public LinkedNode(LinkedNode next, E value)
        {
            this.next = next;
            this.value = value;
        }
    }

    public LinkedNode head = new LinkedNode(null);
    public LinkedNode tail = null;

    public LinkedList() {
        tail = head;
    }
}