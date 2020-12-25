package exercise.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import exercise.common.*;

// 打印二维bool数组
public class Exercise11_boolMat {
    public static void main(String[] args) {
        int N = 10;
        int M = 10;
        if (args.length >= 2) {
            N = Integer.parseInt(args[1]);
            M = Integer.parseInt(args[2]);
        }
        boolean[][] mat = createBoolMat(N, M);
        printBoolMat(mat);
    }

    public static boolean[][] createBoolMat(int N, int M) {
        boolean[][] mat = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mat[i][j] = RandUtil.randBool();
            }
        }
        return mat;
    }

    public static void printBoolMat(boolean[][] array) {
        StdOut.print("  ");
        for (int i = 0; i < array.length; i++) {
            StdOut.printf(" %d", i+1);
        }
        StdOut.println();
        for (int i = 0; i < array.length; i++) {
            StdOut.printf("%2d", i+1);
            for (int j = 0; j < array[i].length; j++) {
                String text = " ";
                if (array[i][j]) {
                    text = "*";
                }
                StdOut.printf(" %s", text);
            }
            StdOut.println();
        }
    }
}