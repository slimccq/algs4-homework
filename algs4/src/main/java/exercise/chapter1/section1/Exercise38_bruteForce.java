package exercise.chapter1.section1;


import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.BinarySearch;
import exercise.common.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

// 二分查找与暴力查找
public class Exercise38_bruteForce {

    public static void main(String[] args) {
        Path cwd = Paths.get("");
        String curPath = cwd.toAbsolutePath().toString();
        curPath += "/src/main/resources/";

        StdOut.printf("Current resource path is: %s\n", curPath);

        String name1 = "largeW.txt";
        StdOut.printf("start load file %s\n", name1);
        int[] largeW = Utility.readIntLines(curPath + name1);
        StdOut.printf("load %s with %d integers\n", name1, largeW.length);

        String name2 = "largeT.txt";
        StdOut.printf("start load file %s\n", name2);
        int[] largeT = Utility.readIntLines(curPath + name2);
        StdOut.printf("load %s with %d integers\n", name2, largeT.length);

        int target = RandUtil.randInt(10000);
        //int target = 4468;
        benchSearch(name1, largeW, target);
        benchSearch(name2, largeT, target);
    }

    public static void benchSearch(String name, int[] arr, int target) {
        Arrays.sort(arr);
        long t1 = System.nanoTime();
        int i = BinarySearch.searchInt(arr, target);
        long t2 = System.nanoTime();
        int j = bruteForceSearch(arr, target);
        long t3 = System.nanoTime();
        StdOut.printf("benchmark for search %d at %s:\n", target, name);
        StdOut.printf("\tbrute force   %d: cost %dns\n", j, t3 - t2);
        StdOut.printf("\tbinary search %d: cost %dns, %.2f times faster.\n", i, t2 - t1,
                (double) (t3 - t2) / (double) (t2 - t1));
    }

    public static int bruteForceSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
