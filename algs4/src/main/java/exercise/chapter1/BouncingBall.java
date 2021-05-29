package exercise.chapter1;

import edu.princeton.cs.algs4.StdDraw;

public class BouncingBall {
    public static void main(String[] args) {
        StdDraw.setXscale(-1, 1);
        StdDraw.setYscale(-1, 1);
        StdDraw.enableDoubleBuffering();

        double rx = 0.48;
        double ry = 0.86;
        double vx = 0.015;
        double vy = 0.023;
        double radius = 0.05;

        while (true) {
            if (Math.abs(rx + vx) > 1.0 - radius) {
                vx = -vx;
            }
            if (Math.abs(ry + vy) > 1.0 - radius) {
                vy = -vy;
            }

            // update position
            rx += vx;
            ry += vy;

            // clean background
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledSquare(0, 0, 1);

            // draw ball on the screen
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(rx, ry, radius);

            // display and pause
            StdDraw.show();
            StdDraw.pause(10);
        }
    }
}
