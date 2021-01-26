package exercise.chapter1;

import edu.princeton.cs.algs4.StdOut;

// 单链表
public class LinkedList {
    // 哨兵头节点
    public LinkedNode sentinel = new LinkedNode(null);

    public LinkedList() {
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

    // 头节点
    public LinkedNode first() {
        return sentinel.next;
    }

    // 链表是否有环
    public boolean hasCycle() {
        LinkedNode slow = sentinel.next;
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

    // 头部插入
    public void insertHead(LinkedNode node) {
        LinkedNode head = sentinel.next;
        node.next = head;
        sentinel.next = node;
    }

    // 尾部插入
    public void insertTail(LinkedNode node) {
        LinkedNode last = sentinel;
        while(last.next != null) {
            last = last.next;
        }
        last.next = node;
    }

    // Exercise 1.3.25
    // 把b插入到a后面
    public void insertAfter(LinkedNode a, LinkedNode b) {
        b.next = a.next;
        a.next = b;
    }

    // Exercise 1.3.24
    public void removeAfter(LinkedNode node) {
        node.next = null;
    }

    // 根据int数组创建一个链表
    public static LinkedList makeIntList(Integer[] array) {
        LinkedList list = new LinkedList();
        int n = array.length;
        if (n == 0) {
            return list;
        }
        LinkedNode prev = list.sentinel;
        for (int i = 0; i < n; i++) {
            LinkedNode node = new LinkedNode(null, array[i]);
            prev.next = node;
            prev = node;
        }
        assert !list.hasCycle();
        return list;
    }

    // 打印整数链表
    public static void printIntList(LinkedList list) {
        StdOut.print("[");
        LinkedNode node = list.sentinel.next;
        while (node != null) {
            StdOut.printf(" %d ", node.value);
            node = node.next;
        }
        StdOut.print("]\n");
    }

    public static class LinkedNode {
        public LinkedNode next = null;
        public Object value;

        public LinkedNode(Object value) {
            this.value = value;
        }

        public LinkedNode(LinkedNode next, Object value) {
            this.next = next;
            this.value = value;
        }
    }
}