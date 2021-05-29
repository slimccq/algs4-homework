package exercise.chapter1.section5;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_QuickFind {
    private static int[] id;
    private static int read = 0; //
    private static int write = 0; //

    private static void init(int N) {
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    private static int find(int q) {
        read++;
        return id[q];
    }

    private static void union(int p, int q) {
        int j = find(p);
        int k = find(q);
        if (k == j) {
            return ;
        }
        for (int i = 0; i < id.length; i++) {
            read++;
            if (id[p] == j) {
                write++;
                id[p] = k;
            }
        }
    }

    private static void show(int p, int q) {
        StdOut.printf("result after: %d, %d\n", p, q);
        StdOut.printf("\t");
        for (int i = 0; i < id.length; i++) {
            StdOut.printf("%d, ", id[i]);
        }
        StdOut.println();
        StdOut.printf("\tread write: %d / %d\n", read, write);
    }

    public static void main(String[] args) {
        int[] input = new int[]{
                9,0,
                3,4,
                5,8,
                7,2,
                2,1,
                5,7,
                0,3,
                4,2,
        };
        init(input.length);
        for (int i = 0; i < input.length; i+= 2) {
            read = 0;
            write = 0;
            int p = input[i];
            int q = input[i+1];
            //StdOut.printf("%d %d\n", p, q);
            union(p, q);
            show(p, q);
        }
    }
}