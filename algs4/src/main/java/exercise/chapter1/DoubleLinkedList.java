package exercise.chapter1;

// 双端链表
public class DoubleLinkedList<E> {

    public static class DoubleLinkedNode<E> {
        public DoubleLinkedNode prev = null;
        public DoubleLinkedNode next = null;
        public E value;

        public DoubleLinkedNode(E value) {
            this.value = value;
        }

        public DoubleLinkedNode(DoubleLinkedNode prev, DoubleLinkedNode next, E v) {
            this.prev = prev;
            this.next = next;
            this.value = v;
        }
    }

    public DoubleLinkedNode head = null;
    public DoubleLinkedNode tail = null;

    public DoubleLinkedList() {

    }
}