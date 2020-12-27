package exercise.chapter1;

import edu.princeton.cs.algs4.StdOut;


// 双端链表 Exercise 1.3.31
public class DoubleLinkedList {

    // first dummy sentinel node
    public LinkedNode sentinel = new LinkedNode(null);
    public LinkedNode last = null;

    public DoubleLinkedList() {
    }

    public int size() {
        int n = 0;
        LinkedNode node = sentinel.next;
        while(node != null) {
            node = node.next;
            n++;
        }
        return n;
    }

    public LinkedNode first() {
        return sentinel.next;
    }

    // 在头部插入节点
    public void insertHead(LinkedNode node) {
        LinkedNode head = sentinel.next;
        if (head == null) {
            last = node;
        } else {
            head.prev = node;
        }
        node.next = head;
        sentinel.next = node;
    }

    // 在尾部插入节点
    public void insertTail(LinkedNode node) {
        if (sentinel.next == null) {
            sentinel.next = node;
            last = node;
        } else {
            last.next = node;
        }
        node.prev = last;
        last = node;
    }

    // 把节点b插入到节点a之前
    public void insertBefore(LinkedNode a, LinkedNode b) {
        if (a.prev != null) {
            a.prev.next = b;
        }
        b.prev = a.prev;
        b.next = a;
        a.prev = b;
    }

    // Exercise 1.3.25, 把节点b插入到节点a后
    public void insertAfter(LinkedNode a, LinkedNode b) {
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
    public LinkedNode removeHead() {
        LinkedNode head = sentinel.next;
        if (head == null) {
            return null;
        }
        sentinel.next = head.next;
        head.next.prev = sentinel;
        head.prev = null;
        head.next = null;
        return head;
    }

    // 删除尾节点
    public LinkedNode removeTail() {
        LinkedNode prev = last.prev;
        LinkedNode node = last;
        if (prev != null) {
            prev.next = null;
        }
        last.prev = null;
        last = prev;
        return node;
    }

    // Exercise 1.3.24, 删除node以后的节点
    public void removeAfter(LinkedNode node) {
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
        for (int i = 0; i < n; i++) {
            LinkedNode node = new LinkedNode(array[i]);
            list.insertTail(node);
        }
        return list;
    }

    public static void printIntList(DoubleLinkedList list) {
        StdOut.print("[");
        LinkedNode node = list.sentinel.next;
        while (node != null) {
            StdOut.printf(" %d ", node.value);
            node = node.next;
        }
        StdOut.print("]\n");
    }

    public static class LinkedNode {
        public LinkedNode prev = null;
        public LinkedNode next = null;
        public Object value;

        public LinkedNode(Object value) {
            this.value = value;
        }
    }
}