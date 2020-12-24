package exercise.common;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Random;

public class RandUtil {

    public static boolean randBool() {
        return StdRandom.uniform(2) == 0;
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

