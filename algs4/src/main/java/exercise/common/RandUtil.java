package exercise.common;

import edu.princeton.cs.algs4.StdRandom;

import java.util.*;

public class RandUtil {

    public static boolean randBool() {
        return StdRandom.bernoulli();
    }

    public static int randInt(int N) {
        return StdRandom.uniform(N);
    }

    public static int[] randIntArray(int N) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = StdRandom.uniform(100);
        }
        return arr;
    }

    // 随机M个重复值
    public static int[] randIntArray(int N, int M) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            if (i > 0 && M > 0 && StdRandom.bernoulli()) {
                M--;
                int idx = StdRandom.uniform(i);
                arr[i] = arr[idx];
            }
            arr[i] = StdRandom.uniform(100);
        }
        return arr;
    }

    // 随机不重复数组
    public static int[] randUniqueIntArray(int N) {
        Set<Integer> exist = new HashSet<>();
        while(true) {
            int n = StdRandom.uniform(100);
            exist.add(n);
            if (exist.size() == N) {
                break;
            }
        }
        int[] arr = new int[N];
        int i = 0;
        for(Integer n : exist) {
            arr[i++] = n;
        }
        return arr;
    }

    public static Integer[] randIntegerArray(int N) {
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = StdRandom.uniform(100);
        }
        return arr;
    }

    public static double[] randDoubleArray(int N) {
        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = 100 * StdRandom.uniform();
        }
        return arr;
    }

    public static Double[] randDoubleObjectArray(int N) {
        Double[] arr = new Double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = StdRandom.uniform();
        }
        return arr;
    }

    // knuth shuffle
    public static void shuffleArray(Object[] arr, int n) {
        Random rnd = new Random();
        for (int i = n - 1; i > 0; i--) {
            int j = Math.abs(rnd.nextInt()) % (i + 1);
            //System.out.printf("swap %d <--> %d\n", i, j);
            Object tmp = arr[j];
            arr[j] = arr[i];
            arr[i] = tmp;
        }
    }


    // reverse array at [lo, hi)
    public static void reverseArray(Object[] arr, int lo, int hi) {
        hi--;
        while (lo < hi) {
            Object tmp = arr[lo];
            arr[lo++] = arr[hi];
            arr[hi--] = tmp;
        }
    }

    public static Integer[] randomIntArray(int N) {
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = StdRandom.uniform(100);
        }
        return arr;
    }

    public static Double[] randomDoubleArray(int N) {
        Double[] arr = new Double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = StdRandom.uniform();
        }
        return arr;
    }

    public static void randomShuffleArray(Comparable[] arr) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = rnd.nextInt(i + 1);
            Comparable tmp = arr[r];
            arr[r] = arr[i];
            arr[i] = tmp;
        }
    }

    // Exercise 2.1.36
    // 生成不均匀额数据 一半为0，一半为1
    public static Integer[] randomUnUniformArray1(int N) {
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N / 2; i++) {
            arr[i] = 0;
            arr[N - i - 1] = 1;
        }
        randomShuffleArray(arr);
        return arr;
    }

    // 生成不均匀额数据 一半为0，1/4为1， 1/4为2
    public static Integer[] randomUnUniformArray2(int N) {
        Integer[] arr = new Integer[N];
        int i = 0;
        for (; i < N / 2; i++) {
            arr[i] = 0;
        }
        int n = i + N / 4;
        for (; i < n; i++) {
            arr[n] = 1;
        }
        for (; i < N; i++) {
            arr[n] = 2;
        }
        randomShuffleArray(arr);
        return arr;
    }

    // 生成不均匀额数据 一半为0，一半是随机int值
    public static Integer[] randomUnUniformArray3(int N) {
        Random rnd = new Random();
        Integer[] arr = new Integer[N];
        int i = 0;
        for (; i < N / 2; i++) {
            arr[i] = 0;
        }
        for (; i < N; i++) {
            arr[i] = rnd.nextInt();
        }
        randomShuffleArray(arr);
        return arr;
    }

    // Exercise 2.1.36
    // 95%有序，其余部分为随机值
    public static Integer[] randomPartialOrderedArray(int N) {
        Random rnd = new Random();
        Integer[] arr = new Integer[N];
        int ordered_count = N * 95 / 100;
        for (int i = 0; i < ordered_count; i++) {
            arr[i] = rnd.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < N - ordered_count; i++) {
            arr[i] = rnd.nextInt();
        }
        return arr;
    }

    public static LinkedList<Comparable> arrayToList(Comparable[] arr) {
        LinkedList<Comparable> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            list.addLast(arr[i]);
        }
        return list;
    }
}

