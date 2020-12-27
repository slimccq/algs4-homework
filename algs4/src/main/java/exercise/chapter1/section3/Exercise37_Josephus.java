package exercise.chapter1.section3;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.CircularList;

// 约瑟夫环
public class Exercise37_Josephus {
    public static void main(String[] args) {
        int N = 7;
        int M = 2;
        if (args.length > 2) {
            N = Integer.parseInt(args[1]);
            M = Integer.parseInt(args[2]);
        }
        StdOut.printf("josephus with queue:\n");
        Josephus1(N, M);
        StdOut.printf("josephus with linked list:\n");
        Josephus2(N, M);
    }

    // 使用queue
    public static void Josephus1(int N, int M) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        while (queue.size() > 1) {
            for (int i = 0; i < M-1; i++) {
                int top = queue.dequeue();
                queue.enqueue(top);
            }
            int target = queue.dequeue();
            StdOut.printf("%d ", target);
        }
        StdOut.printf("killed\nlast alive is %d\n", queue.peek());
    }

    // 使用循环链表
    public static void Josephus2(int N, int M) {
        CircularList list = new CircularList();
        for (int i = 0; i < N; i++) {
            CircularList.ListNode node = new CircularList.ListNode(i);
            list.insertTail(node);
        }
        CircularList.ListNode node = list.first;
        while (N-- > 1) {
            CircularList.ListNode prev = null;
            for (int i = 0; i < M-1; i++) {
                prev = node;
                node = node.next;
            }
            // 删除node节点
            prev.next = node.next;
            node.next = null;
            int target = (Integer)node.value;
            node = prev.next;
            StdOut.printf("%d ", target);
        }
        StdOut.printf("killed.\nlast alive is %d\n", (Integer)node.value);
    }
}