package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.DoubleLinkedList;
import exercise.chapter1.LinkedList;
import exercise.common.RandUtil;

// 删除链表第k个节点
public class Exercise20_DelListKth {
    public static void main(String[] args)
    {
        int N = 10;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        Integer[] arr = RandUtil.randIntegerArray(N);
        int k = 1 + RandUtil.randInt(N);
        LinkedList slist = LinkedList.makeIntList(arr);
        StdOut.printf("single linked list:\n");
        LinkedList.printIntList(slist);
        StdOut.printf("after remove %dth node:\n", k);
        deleteKthNode(slist, k);
        LinkedList.printIntList(slist);

        DoubleLinkedList dlist = DoubleLinkedList.makeIntList(arr);
        StdOut.printf("doubly linked list:\n");
        DoubleLinkedList.printIntList(dlist);
        StdOut.printf("after remove %dth node:\n", k);
        deleteKthNode(dlist, k);
        DoubleLinkedList.printIntList(dlist);
    }

    // 单链表删除第k个元素
    public static void deleteKthNode(LinkedList slist, int k) {
        LinkedList.LinkedNode<Integer> prev = slist.first;
        LinkedList.LinkedNode<Integer> node = prev.next;
        while (node != null && --k > 0) {
            prev = node;
            node = node.next;
        }
        if (node != null) {
            prev.next = node.next;
        } else {
            prev.next = null;
        }
    }

    // 双链表删除第k个元素
    public static void deleteKthNode(DoubleLinkedList dlist, int k) {
        DoubleLinkedList.DoubleLinkedNode<Integer> node = dlist.first;
        while (node != null && k-- > 0) {
            node = node.next;
        }
        node.prev.next = node.next;
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = null;
        node.prev = null;
    }
}