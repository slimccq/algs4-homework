package exercise.chapter1.section5;

import edu.princeton.cs.algs4.StdOut;

public class Exercise1_QuickFind {
    private static int[] id;
    private static int touch_n = 0; // 访问次数

    private static void init(int N) {
        id = new int[N];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    private static int find(int q) {
        touch_n++;
        return id[q];
    }

    private static void union(int p, int q) {
        int j = find(p);
        int k = find(q);
        if (k == j) {
            return ;
        }
        for (int i = 0; i < id.length; i++) {
            touch_n++;
            if (id[p] == j) {
                touch_n++;
                id[p] = k;
            }
        }
    }

    private static void show() {
        for (int i = 0; i < id.length; i++) {
            StdOut.printf("%d, ", id[i]);
        }
        StdOut.println();
        StdOut.printf("touch count: %d\n", touch_n);
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
            touch_n = 0;
            int p = input[i];
            int q = input[i+1];
            //StdOut.printf("%d %d\n", p, q);
            union(p, q);
            show();
        }
    }
}