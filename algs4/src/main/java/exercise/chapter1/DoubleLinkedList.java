package exercise.chapter1;

import edu.princeton.cs.algs4.StdOut;


// 双端链表 Exercise 1.3.31
public class DoubleLinkedList {

    // first dummy sentinel node
    public DoubleLinkedNode first = new DoubleLinkedNode(null);

    public DoubleLinkedList() {
    }

    public int size() {
        int n = 0;
        DoubleLinkedNode node = first.next;
        while(node != null) {
            node = node.next;
            n++;
        }
        return n;
    }

    // 在头部插入节点
    public void insertHead(DoubleLinkedNode node) {
        DoubleLinkedNode head = first.next;
        node.next = head;
        head.prev = node;
        first.next = node;
    }

    // 在尾部插入节点
    public void insertTail(DoubleLinkedNode node) {
        DoubleLinkedNode last = first.next;
        while(last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
    }

    // 把节点b插入到节点a之前
    public void insertBefore(DoubleLinkedNode a, DoubleLinkedNode b) {
        if (a.prev != null) {
            a.prev.next = b;
        }
        b.prev = a.prev;
        b.next = a;
        a.prev = b;
    }

    // Exercise 1.3.25, 把节点b插入到节点a后
    public void insertAfter(DoubleLinkedNode a, DoubleLinkedNode b) {
        if (a == null || b == null) {
            return ;
        }
        if (a.next != null) {
            a.next.prev = b;
        }
        b.next = a.next;
        a.next = b;
        b.prev = a;
    }

    // 删除头节点
    public DoubleLinkedNode removeHead() {
        DoubleLinkedNode head = first.next;
        if (head == null) {
            return null;
        }
        first.next = head.next;
        head.next.prev = first;
        head.prev = null;
        head.next = null;
        return head;
    }

    // 删除尾节点
    public DoubleLinkedNode removeTail() {
        DoubleLinkedNode node = first.next;
        DoubleLinkedNode prev = first;
        while(node.next != null) {
            prev = node;
            node = node.next;
        }
        prev.next = null;
        node.prev = null;
        return node;
    }

    // Exercise 1.3.24, 删除node以后的节点
    public void removeAfter(DoubleLinkedNode node) {
        if (node == null) {
            return ;
        }
        if (node.next != null) {
            node.next.prev = null;
            node.next = null;
        }
    }

    // 根据int数组创建一个链表
    public static DoubleLinkedList makeIntList(Integer[] array) {
        DoubleLinkedList list = new DoubleLinkedList();
        int n = array.length;
        if (n == 0) {
            return list;
        }
        DoubleLinkedNode prev = list.first;
        for (int i = 0; i < n; i++) {
            DoubleLinkedNode node = new DoubleLinkedNode(array[i]);
            node.prev = prev;
            prev.next = node;
            prev = node;
        }
        return list;
    }

    public static void printIntList(DoubleLinkedList list) {
        StdOut.print("[");
        DoubleLinkedNode node = list.first.next;
        while (node != null) {
            StdOut.printf(" %d ", node.value);
            node = node.next;
        }
        StdOut.print("]\n");
    }

    public static class DoubleLinkedNode {
        public DoubleLinkedNode prev = null;
        public DoubleLinkedNode next = null;
        public Object value;

        public DoubleLinkedNode(Object value) {
            this.value = value;
        }
    }
}