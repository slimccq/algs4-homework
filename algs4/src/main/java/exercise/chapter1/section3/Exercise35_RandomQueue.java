package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.RandomQueue;

import java.util.Arrays;
import java.util.Collections;

// 随机队列发牌
public class Exercise35_RandomQueue {
    public static void main(String[] args) {
        RandomQueue<Integer> queue = new RandomQueue(52);
        for (int i = 0; i < 52; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < 4; i++) {
            StdOut.printf("player %d: ", i+1);
            int[] cards = new int[13];
            for (int j = 0; j < 13; j++) {
                int card = queue.dequeue();
                cards[j] = card;
            }
            sortCards(cards);
            for (int k = 0; k < cards.length; k++) {
                StdOut.printf("%s, ", prettyCard(cards[k]));
            }
            StdOut.println();
        }
    }

    // 52张牌
    // 0-12: Diamond 2、3、4、5、6、7、8、9、10、J、Q、K、A
    // 13-25: Club 2-A
    // 26-38: Heart 2-A
    // 39-51: Spade 2-A
    private static String prettyCard(int idx) {
        String color = "";
        if (idx < 13) {
            color = "♦"; // diamond
        } else if (idx < 26) {
            color = "♣"; // club
        } else if (idx < 39) {
            color = "♥"; // heart
        } else if (idx < 52) {
            color = "♠"; // spade
        }
        String faceValue = "";
        int n = idx % 13;
        if (n == 12) {
            faceValue = "A";
        } else if (n == 11) {
            faceValue = "K";
        } else if (n == 10) {
            faceValue = "Q";
        } else if (n == 9) {
            faceValue = "J";
        } else if (n >= 0) {
            faceValue = (n + 2) + "";
        }
        return String.format("%s%s", color, faceValue);
    }

    // 跳过花色排序
    public static void sortCards(int[] cards) {
        for (int i = 1; i < cards.length; i++)
        {
            for (int j = i; j > 0 && cards[j]%13 < cards[j-1]%13; j--)
            {
                int tmp = cards[j];
                cards[j] = cards[j-1];
                cards[j-1] = tmp;
            }
        }
    }
}