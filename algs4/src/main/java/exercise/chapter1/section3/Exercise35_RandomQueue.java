package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.RandomQueue;

public class Exercise35_RandomQueue {
    public static void main(String[] args) {
        RandomQueue<Integer> queue = new RandomQueue(52);
        for (int i = 0; i < 52; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 4; i++) {
            StdOut.printf("player %d: ", i+1);
            for (int j = 0; j < 13; j++) {
                int idx = queue.dequeue();
                StdOut.printf("%s, ", prettyCard(idx));
            }
            StdOut.println();
        }
    }

    // 52张牌
    // 0-12: Spade 2、3、4、5、6、7、8、9、10、J、Q、K、A
    // 13-25: Heart 2-A
    // 26-38: Club 2-A
    // 39-51: Diamond 2-A
    private static String prettyCard(int idx) {
        String color = "";
        if (idx < 13) {
            color = "♠️"; //
        } else if (idx < 26) {
            color = "♥️";
        } else if (idx < 39) {
            color = "♣️";
        } else if (idx < 52) {
            color = "♦️";
        }
        String faceValue = "";
        int n = idx % 13;
        switch (n) {
            case 12:
                faceValue = "A";
            case 11:
                faceValue = "K";
            case 10:
                faceValue = "Q";
            case 9:
                faceValue = "J";
            default:
                faceValue = (n + 2) + "";
        }
        return String.format("%s%s", color, faceValue);
    }
}