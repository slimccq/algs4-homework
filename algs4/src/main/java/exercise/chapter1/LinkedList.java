package exercise.chapter1;

import edu.princeton.cs.algs4.StdOut;

// 单链表
public class LinkedList<E> {
    // first dummy sentinel node
    public LinkedNode first = new LinkedNode(null);

    public LinkedList() {
    }

    public int size() {
        int n = 0;
        LinkedNode node = first.next;
        while(node != null) {
            node = node.next;
            n++;
        }
        return n;
    }

    public boolean hasCycle() {
        LinkedNode slow = first.next;
        LinkedNode fast = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // Exercise 1.3.25
    public void insertAfter(LinkedNode a, LinkedNode b) {
        b.next = a.next;
        a.next = b;
    }

    // Exercise 1.3.24
    public void removeAfter(LinkedNode node) {
        node.next = null;
    }

    // 根据int数组创建一个链表
    public static LinkedList<Integer> makeIntList(Integer[] array) {
        LinkedList<Integer> list = new LinkedList<>();
        int n = array.length;
        if (n == 0) {
            return list;
        }
        LinkedNode<Integer> prev = list.first;
        for (int i = 0; i < n; i++) {
            LinkedNode<Integer> node = new LinkedNode<>(null, array[i]);
            prev.next = node;
            prev = node;
        }
        assert !list.hasCycle();
        return list;
    }

    // 打印整数链表
    public static void printIntList(LinkedList<Integer> list) {
        StdOut.print("[");
        LinkedNode<Integer> node = list.first.next;
        while (node != null) {
            StdOut.printf(" %d ", node.value);
            node = node.next;
        }
        StdOut.print("]\n");
    }

    public static class LinkedNode<E> {
        public LinkedNode next = null;
        public E value;

        public LinkedNode(E value) {
            this.value = value;
        }

        public LinkedNode(LinkedNode next, E value) {
            this.next = next;
            this.value = value;
        }
    }
}