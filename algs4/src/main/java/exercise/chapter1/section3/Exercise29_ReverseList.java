package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.LinkedList;
import exercise.common.RandUtil;

// 反转单链表
public class Exercise29_ReverseList {
    public static void main(String[] args) {
        int N = 10;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        Integer[] arr = RandUtil.randIntegerArray(N);
        LinkedList slist = LinkedList.makeIntList(arr);
        StdOut.printf("create linked list:\n");
        LinkedList.printIntList(slist);
        slist.sentinel.next = reverseListRecursive(slist.sentinel.next);
        StdOut.printf("after reversion:\n");
        LinkedList.printIntList(slist);
    }

    // 反转单链表
    public static LinkedList.LinkedNode reverseList(LinkedList.LinkedNode node) {
        LinkedList.LinkedNode prev = null;
        while (node != null) {
            LinkedList.LinkedNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    // 递归版本
    public static LinkedList.LinkedNode reverseListRecursive(LinkedList.LinkedNode node)
    {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }
        LinkedList.LinkedNode next = node.next;
        LinkedList.LinkedNode prev = reverseListRecursive(next);
        next.next = node;
        node.next = null;
        return prev;
    }
}