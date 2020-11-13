package com.example.chapter1;


import edu.princeton.cs.algs4.StdOut;

// Exercise 1.3.37 约瑟夫环
public class Josephus {

    // f(1, 1) => 1
    // f(n, m) => (f(n-1, m) + m - 1) % n
    public void useFormula(int N, int M)
    {
        if (N == 0)
            return;
        int r = 0;
        for (int i = 2; i <= N; i++)
        {
            r = (r + M) % i;
            System.out.println("Kill " + r);
        }
        System.out.println("last alive is " + (r + 1));
    }

    public void useList(int N, int M)
    {
        if (N == 0)
            return ;
        LinkedNode<Integer> head = new LinkedNode<>(null, 0, null);
        LinkedNode<Integer> curr = head;
        for (int i = 1; i < N; i++)
        {
            LinkedNode<Integer> node = new LinkedNode<>(null, i, null);
            curr.linkAfter(node);
            curr = node;
        }
        head.linkCircle(curr);

        curr = head;
        while (N-- > 1)
        {
            for (int i = 0; i < M - 1; i++)
            {
                curr = curr.next;
            }
            // delete node
            LinkedNode<Integer> next = curr.next;
            StdOut.printf("kill %d\n", curr.item);
            curr.unlink();
            curr = next;
        }
        StdOut.printf("last aliveis %d\n", curr.item);
    }

    public static void useQueue(int N, int M)
    {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        while (queue.size() > 1)
        {
            for (int i = 0; i < M - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            Integer t = queue.dequeue();
            StdOut.printf("kill %d\n", t);
        }
        StdOut.printf("last alive is %d\n", queue.dequeue());
    }

    public static void main(String[] args)
    {
        int N = Integer.parseInt(args[0]);
        int M = Integer.parseInt(args[1]);
        Josephus problem = new Josephus();
        System.out.println("list method:");
        problem.useList(N, M);
        System.out.println("queue method:");
        problem.useQueue(N, M);
    }
}
