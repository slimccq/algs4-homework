package exercise.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import exercise.common.RandUtil;

// 二维数组行列转置
public class Exercise13_transposeMat {
    public static void main(String[] args) {
        int N = 3;
        int M = 4;
        if (args.length >= 2) {
            N = Integer.parseInt(args[1]);
            M = Integer.parseInt(args[2]);
        }
        int[][] mat = createMat(N, M);
        StdOut.println("before:");
        printMat(mat);
        StdOut.println("after:");
        int[][] newmat = transposeMat(mat);
        printMat(newmat);
    }

    public static int[][] transposeMat(int[][] mat) {
        int N = mat.length;
        int M = mat[0].length;
        int[][] newMat = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMat[j][i] = mat[i][j];
            }
        }
        return newMat;
    }

    public static int[][] createMat(int N, int M)
    {
        int[][] mat = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                mat[i][j] = RandUtil.randInt(100);
            }
        }
        return mat;
    }

    public static void printMat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                StdOut.printf("  %2d", mat[i][j]);
            }
            StdOut.println();
        }
    }
}