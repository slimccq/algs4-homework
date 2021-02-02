package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.LinkedList;

// 实现前移编码
public class Exercise40_MoveToFront {
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        StdOut.printf("enter something:\n");
        while (StdIn.hasNextChar()) {
            char c = StdIn.readChar();
            removeOld(list, c);
            LinkedList.LinkedNode node = new LinkedList.LinkedNode(c);
            list.insertHead(node);
            printList(list);
        }
    }

    // 读取了一个重复的字符时,将它从链表中删去并再次插入表头
    public static void removeOld(LinkedList list, char c) {
        LinkedList.LinkedNode node = list.sentinel;
        while (node.next != null) {
            LinkedList.LinkedNode next = node.next;
            if (next.value.equals(c)) {
                node.next = next.next;
                break;
            } else {
                node = node.next;
            }
        }
    }

    public static void printList(LinkedList list) {
        LinkedList.LinkedNode node = list.sentinel.next;
        while(node != null) {
            StdOut.printf("%s ", node.value);
            node = node.next;
        }
        StdOut.println();
    }
}
