package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.DoubleLinkedList;
import exercise.chapter1.LinkedList;
import exercise.common.RandUtil;

// 根据key删除链表尾节点
public class Exercise26_ListRemove {
    public static void main(String[] args)
    {
        int N = 10;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        Integer[] arr = RandUtil.randIntegerArray(N);
        int key = arr[RandUtil.randInt(N)];
        LinkedList slist = LinkedList.makeIntList(arr);
        StdOut.printf("single linked list:\n");
        LinkedList.printIntList(slist);
        StdOut.printf("remove target %d in list: ", key);
        int count = removeNode(slist, key);
        StdOut.printf("#%d items removed\n", count);

        DoubleLinkedList dlist = DoubleLinkedList.makeIntList(arr);
        StdOut.printf("doubly linked list:\n");
        DoubleLinkedList.printIntList(dlist);
        StdOut.printf("remove target %d in list: ", key);
        count = removeNode(dlist, key);
        StdOut.printf("#%d items removed\n", count);
    }

    // 单链表删除值为key的元素
    public static int removeNode(LinkedList slist, int key) {
        int count = 0;
        LinkedList.LinkedNode prev = slist.sentinel;
        LinkedList.LinkedNode node = prev.next;
        while (node != null) {
            if (node.value.equals(key)) {
                prev.next = node.next;
                count++;
            } else {
                prev = node;
            }
            node = node.next;
        }
        return count;
    }

    // 双链表删除值为key的元素
    public static int removeNode(DoubleLinkedList dlist, int key) {
        int count = 0;
        DoubleLinkedList.LinkedNode node = dlist.sentinel.next;
        while (node != null) {
            if (node.value.equals(key)) {
                node.prev.next = node.next;
                if (node.next != null) {
                    node.next.prev = node.prev;
                }
                count++;
            }
            node = node.next;
        }
        return count;
    }
}