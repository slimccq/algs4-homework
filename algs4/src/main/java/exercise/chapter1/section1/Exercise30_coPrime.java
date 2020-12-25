package exercise.chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

// 计算NxN阵列的互质数
public class Exercise30_coPrime {
    public static void main(String[] args) {
        int N = 10;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        boolean[][] arr = new boolean[N][N];
        calcCoprime(arr, N);
        printBoolMat(arr);
    }

    public static void calcCoprime(boolean[][] arr, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (isCoPrime(i, j)) {
                    arr[i][j] = true;
                }
            }
        }
    }

    public static boolean isCoPrime(int a, int b) {
        if (a == b && a != 1) {
            return false;
        }

        // The only integers that are coprime to zero are 1 and -1
        if (a == 0 || b == 0) {
            return (a + b) == 1 || (a + b) == -1;
        }
        return gcd(a, b) == 1;
    }

    public static int gcd(int p, int q) {
        while (q > 0) {
            int r = p % q;
            p = q;
            q = r;
        }
        return p;
    }

    public static void printBoolMat(boolean[][] array) {
        StdOut.print("  ");
        for (int i = 0; i < array.length; i++) {
            StdOut.printf(" %d", i);
        }
        StdOut.println();
        for (int i = 0; i < array.length; i++) {
            StdOut.printf("%2d", i);
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
