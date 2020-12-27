package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.DoubleLinkedList;
import exercise.chapter1.LinkedList;
import exercise.common.RandUtil;

// 整数类型链表最大值节点
public class Exercise27_ListMax {
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
        StdOut.printf("find max element in list: ");
        int max = maxElement(slist);
        StdOut.printf("%d\n", max);

        DoubleLinkedList dlist = DoubleLinkedList.makeIntList(arr);
        StdOut.printf("doubly linked list:\n");
        DoubleLinkedList.printIntList(dlist);
        StdOut.printf("find max element in list: ");
        max = maxElement(dlist);
        StdOut.printf("%d\n", max);
    }

    // 最大值
    public static int maxElement(LinkedList slist) {
        LinkedList.LinkedNode node = slist.first.next;
        int max = (int)node.value;
        while (node.next == null) {
            node = node.next;
            if ((int)node.value > max) {
                max = (int)node.value;
            }
        }
        return max;
    }

    // 最大值
    public static int maxElement(DoubleLinkedList dlist) {
        DoubleLinkedList.DoubleLinkedNode node = dlist.first.next;
        int max = (int)node.value;
        while (node.next == null) {
            node = node.next;
            if ((int)node.value > max) {
                max = (int)node.value;
            }
        }
        return max;
    }
}