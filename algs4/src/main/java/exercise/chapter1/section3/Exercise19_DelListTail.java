package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.DoubleLinkedList;
import exercise.chapter1.LinkedList;
import exercise.common.RandUtil;

// 删除链表尾节点
public class Exercise19_DelListTail {

    public static void main(String[] args)
    {
        int N = 10;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        Integer[] arr = RandUtil.randIntegerArray(N);
        LinkedList slist = LinkedList.makeIntList(arr);
        StdOut.printf("single linked list:\n");
        LinkedList.printIntList(slist);
        StdOut.printf("after remove tail:\n");
        deleteTailNode(slist);
        LinkedList.printIntList(slist);

        DoubleLinkedList dlist = DoubleLinkedList.makeIntList(arr);
        StdOut.printf("doubly linked list:\n");
        DoubleLinkedList.printIntList(dlist);
        StdOut.printf("after remove tail:\n");
        deleteTailNode(dlist);
        DoubleLinkedList.printIntList(dlist);
    }

    // 单链表删除尾节点
    public static void deleteTailNode(LinkedList slist) {
        LinkedList.LinkedNode prev = slist.sentinel;
        LinkedList.LinkedNode node = prev.next;
        while (node != null && node.next != null) {
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }

    // 双链表删除尾节点
    public static void deleteTailNode(DoubleLinkedList dlist) {
        DoubleLinkedList.LinkedNode node = dlist.sentinel;
        while (node != null && node.next != null) {
            node = node.next;
        }
        node.prev.next = node.next;
        node.prev = null;
    }
}