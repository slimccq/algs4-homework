package exercise.common;

import edu.princeton.cs.algs4.StdRandom;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

    public static Double[] randDoubleArray(int N) {
        Double[] arr = new Double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = StdRandom.uniform();
        }
        return arr;
    }

    public static void randShuffleArray(Comparable[] arr) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            int r = rnd.nextInt(i + 1);
            Comparable tmp = arr[r];
            arr[r] = arr[i];
            arr[i] = tmp;
        }
    }


}

