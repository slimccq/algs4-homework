package exercise.chapter1.section2;

import edu.princeton.cs.algs4.StdDraw;

// VisualCounter
public class Exercise10_VisualCounter {

    public static void main(String[] args)
    {
        int N = 10;
        int M = 6;
        if (args.length > 2) {
            N = Integer.parseInt(args[1]);
            M = Integer.parseInt(args[2]);
        }
        VisualCounter counter = new VisualCounter(N, M);
        for (int i = 0; i < 5; i++)
            counter.increment();
        for (int i = 0; i < 3; i++)
            counter.decrement();
    }

    public static class VisualCounter {
        private int N = 0;
        private int max = 0;
        private int total = 0;
        private int counter = 0;

        public VisualCounter(int N, int max) {
            this.N = N;
            this.max = Math.abs(max);
            StdDraw.setCanvasSize(800, 600);
            StdDraw.setPenRadius(0.010);
            StdDraw.setXscale(0, N+1);
            StdDraw.setYscale(-max-3, max+3);
        }

        public void increment() {
            if (total < N && counter < max) {
                total++;
                counter++;
                plotCounter();
            }
        }

        public void decrement() {
            if (total < N && (Math.abs(counter) < max) || (counter == max)) {
                total++;
                counter--;
                plotCounter();
            }
        }

        private void plotCounter() {
            StdDraw.point(total, counter);
        }
    }
}