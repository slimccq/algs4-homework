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
        LinkedList<Integer> slist = LinkedList.makeIntList(arr);
        StdOut.printf("create linked list:\n");
        LinkedList.printIntList(slist);
        slist.first.next = reverseList(slist.first.next);
        StdOut.printf("after reversion:\n");
        LinkedList.printIntList(slist);
    }

    // 反转单链表
    public static LinkedList.LinkedNode<Integer> reverseList(LinkedList.LinkedNode<Integer> node) {
        LinkedList.LinkedNode<Integer> prev = null;
        while (node != null) {
            LinkedList.LinkedNode<Integer> next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}