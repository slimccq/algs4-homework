package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.DoubleLinkedList;
import exercise.chapter1.LinkedList;
import exercise.common.RandUtil;

// 查找链表节点
public class Exercise21_ListFind {
    public static void main(String[] args) {
        int N = 100;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        Integer[] arr = RandUtil.randIntegerArray(N);
        int key = arr[RandUtil.randInt(N)];
        LinkedList slist = LinkedList.makeIntList(arr);
        StdOut.printf("single linked list:\n");
        LinkedList.printIntList(slist);
        StdOut.printf("find %d in list: ", key);
        boolean ok = findNode(slist, key);
        StdOut.printf("%s\n", ok ? "found" : "not found");

        DoubleLinkedList dlist = DoubleLinkedList.makeIntList(arr);
        StdOut.printf("doubly linked list:\n");
        DoubleLinkedList.printIntList(dlist);
        StdOut.printf("find %d in list: ", key);
        ok = findNode(dlist, key);
        StdOut.printf("%s\n", ok ? "found" : "not found");
    }


    // 单链表查找元素
    public static boolean findNode(LinkedList slist, int key) {
        LinkedList.LinkedNode node = slist.first.next;
        while (node != null) {
            if (node.value.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    // 双链表查找元素
    public static boolean findNode(DoubleLinkedList dlist, int key) {
        DoubleLinkedList.DoubleLinkedNode node = dlist.first.next;
        while (node != null) {
            if (node.value.equals(key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}