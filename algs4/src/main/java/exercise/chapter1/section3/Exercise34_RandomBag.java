package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.RandomBag;

// 随机背包
public class Exercise34_RandomBag {
    public static void main(String[] args) {
        RandomBag bag = new RandomBag();
        for (int i = 0; i < 20; i++){
            bag.add(i);
        }
        for (Object n : bag) {
            StdOut.printf("%s ", n.toString());
        }
        StdOut.println();
    }

}